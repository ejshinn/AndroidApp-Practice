package com.example.study06

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.study06.databinding.ItemPersonBinding

class PersonAdapter(val personList:MutableList<Person>): RecyclerView.Adapter<PersonAdapter.Holder>() {
    // 개별항목(item_person)
    inner class Holder(val binding: ItemPersonBinding): RecyclerView.ViewHolder(binding.root) {

        // onBindViewHolder 안의 주석 부분과 같은 의미
        init {
            // 클릭 이벤트
            itemView.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(itemView.context, "클릭 Holder $position", Toast.LENGTH_SHORT).show()
            }

            // 롱클릭
            itemView.setOnLongClickListener {
                val position = adapterPosition
                personList.removeAt(position)
                notifyDataSetChanged()
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.Holder {
        return Holder(ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PersonAdapter.Holder, position: Int) {
        val person = personList.get(position)
        holder.binding.tvName.text  = person.name
        holder.binding.tvPhone.text = person.phone

/*
        // 클릭
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "클릭 $position", Toast.LENGTH_LONG).show()
        }

        // 롱클릭 => 삭제
        holder.itemView.setOnLongClickListener {
            personList.removeAt(position) // personList.remove(person)
            notifyDataSetChanged()
            true
        }
*/
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}