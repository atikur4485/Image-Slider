package com.mnr.imageslider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mnr.imageslider.databinding.ViewPagerItemBinding

class ViewPagerAdapter(
    private val list: List<String>
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ViewPagerItemBinding.bind(itemView)
        fun bind(url: String) {
            Glide.with(binding.root.context)
                .load(url)
                .into(binding.imgId)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item, parent, false)
    )

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}