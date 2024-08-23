package com.example.study06retrofit.comment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.study06retrofit.databinding.ItemCommentBinding

class CommentAdapter (val commentList: MutableList<CommentVO>) : RecyclerView.Adapter<CommentAdapter.Holder>() {
    class Holder(val binding: ItemCommentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val comment = commentList[position]

        holder.binding.txId.text = comment.id.toString()
        holder.binding.txName.text = comment.name
        holder.binding.txEmail.text = comment.email
        holder.binding.txBody.text = comment.body
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}