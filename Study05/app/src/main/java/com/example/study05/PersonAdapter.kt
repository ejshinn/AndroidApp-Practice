package com.example.study05

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.study05.databinding.ItemPersonBinding

class PersonAdapter(val personList: MutableList<PersonItem>) : RecyclerView.Adapter<PersonAdapter.PersonHolder>() {
    // 개별항목(item_person)
    inner class PersonHolder(val binding : ItemPersonBinding):RecyclerView.ViewHolder(binding.root) {

        init { // onBindViewHolder 안의 주석 부분과 같은 의미
            // 클릭 이벤트
            itemView.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(itemView.context, "클릭 personHolder $position", Toast.LENGTH_SHORT).show()
            }

            // 롱클릭 이벤트
            itemView.setOnLongClickListener {
                val position = adapterPosition
                personList.removeAt(position)
                notifyDataSetChanged()

                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        return PersonHolder(ItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        val person = personList.get(position)
        holder.binding.textName.text = person.name
        holder.binding.textPhone.text = person.phone

//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "클릭 $position", Toast.LENGTH_SHORT).show()
//        }
//
//        // 롱클릭 => 삭제
//        holder.itemView.setOnLongClickListener {
//            personList.removeAt(position) // personList.remove(person)
//            notifyDataSetChanged()
//
//            true
//        }
    }
}