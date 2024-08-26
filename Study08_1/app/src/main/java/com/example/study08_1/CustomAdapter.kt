package com.example.study08_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.study08_1.databinding.ItemViewpagerBinding

// RecyclerView.Adapter 이용
class CustomAdapter(val listData: List<String>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemViewpagerBinding): RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        return ViewHolder(ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.binding.textView.text = listData.get(position)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}