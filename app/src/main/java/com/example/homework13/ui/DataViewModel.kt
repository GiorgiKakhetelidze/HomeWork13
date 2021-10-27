package com.example.homework13.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework13.model.NewsItem
import com.example.homework13.network.NetworkClient
import com.example.homework13.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class DataViewModel : ViewModel() {

    private val _data = MutableLiveData<Resource<List<NewsItem>>>()
    val data: MutableLiveData<Resource<List<NewsItem>>> get() = _data

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            try {
                _data.postValue(Resource.Loading(load = true))
                withContext(Dispatchers.IO) {
                    val response = NetworkClient.rentService.getNews()
                    val result = response.body()
                    if (response.isSuccessful && result != null)
                        _data.postValue(Resource.Success(data = result))
                }
            } catch (e: Exception) {
                _data.postValue(Resource.Error(message = e.message.toString()))
            } finally {
                withContext(Dispatchers.IO) {
                    _data.postValue(Resource.Loading(load = false))
                }
            }

        }
    }
}