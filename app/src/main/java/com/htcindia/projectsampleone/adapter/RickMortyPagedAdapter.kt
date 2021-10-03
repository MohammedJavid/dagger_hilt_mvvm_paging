package com.htcindia.projectsampleone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.htcindia.projectsampleone.databinding.RickMortyLayoutBinding
import com.htcindia.projectsampleone.models.RickMorty

class RickMortyPagedAdapter: PagingDataAdapter<RickMorty, RickMortyPagedAdapter.MyViewHolder>(diffCallback) {


    inner class MyViewHolder(private val binding: RickMortyLayoutBinding):
        RecyclerView.ViewHolder(binding.root) {
            fun bind(rickMorty: RickMorty) {
                binding.apply {
                    tvRickMorty.text = rickMorty.name
                    ivRickMorty.load(rickMorty.image) {
                        crossfade(true)
                        crossfade(1000)
                    }
                }
            }
        }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<RickMorty>() {
            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return  oldItem == newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RickMortyLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false))
    }
}