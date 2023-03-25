package com.faiz.newyorktimesnewsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.faiz.newyorktimesnewsapp.databinding.ItemNewsBinding
import com.faiz.newyorktimesnewsapp.domain.model.NewsModel
import com.faiz.newyorktimesnewsapp.BR

class NewsAdapter(private val itemClickListener: OnItemClickListener) :
    ListAdapter<NewsModel, NewsAdapter.NewsVH>(DiffCallback) {
    object DiffCallback : DiffUtil.ItemCallback<NewsModel>() {
        override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(layoutInflater, parent, false)
        return NewsVH(binding)
    }

    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class NewsVH(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: NewsModel) {
            binding.setVariable(BR.news, item)
            binding.executePendingBindings()

            binding.container.setOnClickListener {
                itemClickListener.onItemClick(item)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: NewsModel)
    }
}