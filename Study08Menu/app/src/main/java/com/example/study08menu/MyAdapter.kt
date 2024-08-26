package com.example.study08menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.study08menu.databinding.ItemRecyclerviewBinding

class MyAdapter(val datas: MutableList<String>): RecyclerView.Adapter<MyAdapter.Holder>() {
    class Holder(val binding: ItemRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Holder {
        return Holder(ItemRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyAdapter.Holder, position: Int) {
        holder.binding.itemData.text = datas[position]
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}