package com.example.study11member

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.study11member.databinding.ItemMemberBinding
import retrofit2.Call
import retrofit2.Response

class MemberAdapter(var memberList: MutableList<Member>): RecyclerView.Adapter<MemberAdapter.Holder>() {
    class Holder(val binding: ItemMemberBinding): RecyclerView.ViewHolder(binding.root) {

    }

    // 인터페이스
    interface OnItemClickListener {
        fun onItemClick(member:Member, pos:Int)
    }

    var onItemClickListener:OnItemClickListener?= null

    // 추가
    fun addItem(member: Member) {
        memberList.add(member)
        notifyDataSetChanged()
    }

    // 수정
    fun updateItem(member: Member, position: Int) {
        memberList[position] = member
        notifyDataSetChanged()
    }

    // 삭제
    fun deleteItem(position: Int) {
        memberList.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberAdapter.Holder {
        return Holder(ItemMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MemberAdapter.Holder, position: Int) {
        val member = memberList[position]
        holder.binding.txtId.text = "${member.id}"
        holder.binding.txtName.text = member.name
        holder.binding.txtPhone.text = member.phone
        holder.binding.txtEmail.text = member.email

        // 수정(아이템 클릭)
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(member, position)
        }


        // 삭제(아이템 롱클릭)
        holder.itemView.setOnLongClickListener {
            AlertDialog.Builder(it.context).run {
                setTitle("정말 삭제할까요?")
                setPositiveButton("삭제", DialogInterface.OnClickListener {dialogInterface, i ->
                    MemberClient.retrofit.deleteById(member.id).enqueue(object : retrofit2.Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {
                            deleteItem(holder.adapterPosition)
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {

                        }

                    })
                })

                setNegativeButton("닫기", null)
                show()
            }

            false
        }
    }

    override fun getItemCount(): Int {
        return memberList.size
    }
}