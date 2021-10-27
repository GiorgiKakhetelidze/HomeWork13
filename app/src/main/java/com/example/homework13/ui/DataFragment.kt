package com.example.homework13.ui


import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework13.base.BaseFragment
import com.example.homework13.databinding.DataFragmentBinding
import com.example.homework13.utils.Resource

class DataFragment : BaseFragment<DataFragmentBinding>(DataFragmentBinding::inflate) {

    private val viewModel by viewModels<DataViewModel>()
    private val adapter = NewsAdapter()

    override fun init() {
        setRecycler()
        setObservers()
    }

    private fun setRecycler() {
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }

    private fun setObservers(){
        viewModel.data.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Success -> {
                    adapter.data = resource.data!!
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                    binding.swipeToRefresh.isRefreshing = resource.loading
                }
            }
        }

        binding.swipeToRefresh.setOnRefreshListener {
            viewModel.getData()
        }
    }

}