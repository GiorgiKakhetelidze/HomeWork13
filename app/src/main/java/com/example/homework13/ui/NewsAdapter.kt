package com.example.homework13.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework13.databinding.NewsItemBinding
import com.example.homework13.extensions.setImage
import com.example.homework13.model.NewsItem

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ItemVieHolder>() {

    var data: List<NewsItem> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemVieHolder(
        binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context))
    )

    override fun onBindViewHolder(holder: ItemVieHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = data.size

    inner class ItemVieHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        lateinit var curItem: NewsItem

        fun bind() {
            curItem = data[adapterPosition]
            binding.descriptionTxtView.text = curItem.description
            binding.titleTxtView.text = curItem.title
            binding.dateTxtView.text = curItem.date
            binding.coverImgView.setImage(curItem.imgUrl)
        }

    }

}