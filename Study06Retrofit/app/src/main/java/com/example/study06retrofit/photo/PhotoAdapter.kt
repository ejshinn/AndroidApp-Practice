package com.example.study06retrofit.photo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.study06retrofit.databinding.ItemPhotoBinding

class PhotoAdapter(val photoList: MutableList<Photo>) : RecyclerView.Adapter<PhotoAdapter.Holder>() {
    class Holder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val photo = photoList[position]

        // holder.binding.imageView.setImageResource(R.drawable.ic_launcher_background)
        Glide.with(holder.itemView).load(photo.thumbnailUrl).into(holder.binding.imageView)
        holder.binding.txId.text = photo.id.toString()
        holder.binding.txTitle.text = photo.title
        holder.binding.txUrl.text = photo.url
    }

    override fun getItemCount(): Int {
        return photoList.size
    }
}