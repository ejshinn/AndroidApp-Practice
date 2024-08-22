package com.example.study05

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.study05.databinding.ItemMovieBinding

class MovieAdapter (val movieList : MutableList<MovieItem>) : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    // 리사이클러뷰의 개별 항목 xml(item_movie)
    inner class MovieHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener{
                val position = adapterPosition
                Toast.makeText(itemView.context, "그림 클릭 이벤트 inner class $position", Toast.LENGTH_SHORT).show()
            }
        }

        fun getItem(position:Int) {
            binding.itemImg.setImageResource(movieList[position].posterId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        //holder.binding.itemImg.setImageResource(movieList[position].posterId)
        holder.getItem(position)

//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.binding.root.context, "그림 클릭 이벤트 $position", Toast.LENGTH_SHORT).show()
//        }
    }
}