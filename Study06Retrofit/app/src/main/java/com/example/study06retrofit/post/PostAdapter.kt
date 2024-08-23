package com.example.study06retrofit.post

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.study06retrofit.databinding.ItemPostBinding

class PostAdapter (val postList: MutableList<Post>) : RecyclerView.Adapter<PostAdapter.Holder>() {
    class Holder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val post = postList[position]

        holder.binding.txId.text = post.id.toString()
        holder.binding.txTitle.text = post.title
        holder.binding.txBody.text = post.body
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}