package com.example.study09db1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.study09db1.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.Holder>() {
    var listData = mutableListOf<Memo>()
    var helper: SqliteHelper? = null
    var onItemClickLister:OnItemClickLister? = null

    interface  OnItemClickLister{
        fun onItemClick(pos:Int)
    }

    inner class Holder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        var mMemo: Memo? = null

        init {
            // 삭제 버튼
            binding.buttonDelete.setOnClickListener {
                helper?.deleteMemo(mMemo!!) // db에서 삭제
                listData.remove(mMemo!!) // mutableListOf<Memo>에서 삭제
                notifyDataSetChanged()
            }

            itemView.setOnClickListener {
                onItemClickLister?.onItemClick(adapterPosition)
            }
        }

        fun setMemo(memo: Memo) {
            mMemo = memo
            binding.textNo.text = "${memo.num}"
            binding.textContent.text = memo.content
            // binding.textDatetime.text = "${memo.datetime}" // 날짜 포맷 아님
            // 날짜 포맷 SimpleDataFormat
            val sdf = SimpleDateFormat("yyyy-mm-dd hh:mm")
            binding.textDatetime.text = "${sdf.format(memo.datetime)}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.Holder {
        return Holder(ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.Holder, position: Int) {
        val memo = listData.get(position)
//        holder.binding.textNo.text = memo.num.toString()
//        holder.binding.textNo.text = "${memo.num}"
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}