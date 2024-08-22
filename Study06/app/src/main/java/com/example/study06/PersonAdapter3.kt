package com.example.study06

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.study06.databinding.ItemPersonBinding

class PersonAdapter3(val personList:MutableList<Person3>): RecyclerView.Adapter<PersonAdapter3.Person3Holder>() {
    // 인터페이스
    interface OnItemClickListener {
        fun onItemClick(pos : Int)
    }

    var onItemClickListener : OnItemClickListener? = null

    // 추가
    fun addItem(person : Person3) {
        personList.add(person)
        Log.d("person_interface : ", "add : ${person.name}")

        notifyDataSetChanged()
    }

    // 수정
    fun updateItem(person : Person3, position: Int) { // person => 수정할 내용
        val p = personList[position] // p => 기존 내용
        p.name = person.name
        p.phone = person.phone

        notifyDataSetChanged()
    }

    // 삭제
    fun removeItem(position: Int) {
        personList.removeAt(position)
        notifyDataSetChanged()
    }

    // 개별항목(item_person)
    inner class Person3Holder(val binding: ItemPersonBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onItemClickListener?.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter3.Person3Holder {
        return Person3Holder(ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PersonAdapter3.Person3Holder, position: Int) {
        val person = personList.get(position)
        holder.binding.tvName.text  = person.name
        holder.binding.tvPhone.text = person.phone
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}