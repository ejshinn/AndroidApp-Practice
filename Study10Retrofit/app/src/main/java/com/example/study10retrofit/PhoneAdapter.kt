package com.example.study10retrofit.phone

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.study10retrofit.databinding.CustomPhoneBinding
import com.example.study10retrofit.databinding.ItemPhoneBinding
import retrofit2.Call
import retrofit2.Response

class PhoneAdapter(var phoneList: MutableList<Phone>): RecyclerView.Adapter<PhoneAdapter.Holder>() {

    class Holder(val binding: ItemPhoneBinding): RecyclerView.ViewHolder(binding.root) {

    }

    // 추가
    fun addItem(phone: Phone) {
       phoneList.add(phone)
       notifyDataSetChanged()
    }

    // 수정
    fun updateItem(phone: Phone, position: Int){   //phone  <-- 수정된 phone 객체
        // phoneList 에서 수정안 된 position 의  phone을 수정된 phone으로 변경
        phoneList[position]  = phone
        notifyDataSetChanged()
    }

    // 삭제
    fun removeItem(position: Int) {
        phoneList.removeAt(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ItemPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val phone: Phone = phoneList[position]
        holder.binding.txtName.text = phone.name
        holder.binding.txtPhone.text = phone.phone

        //수정(클릭)
        holder.itemView.setOnClickListener {
            val dialogPhone = CustomPhoneBinding.inflate(LayoutInflater.from(it.context))
            AlertDialog.Builder(it.context).run {
                setTitle("수정")
                setView(dialogPhone.root)
                dialogPhone.edtName.setText("${phone.name}")
                dialogPhone.edtPhone.setText("${phone.phone}")
                setPositiveButton("수정",object:DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        val p = Phone(0,
                            dialogPhone.edtName.text.toString(),
                            dialogPhone.edtPhone.text.toString())
                        PhoneClient.retrofit.update(phone.num, p).enqueue(object : retrofit2.Callback<Phone> {
                            override fun onResponse(call: Call<Phone>, response: Response<Phone>) {
                                // updateItem(response.body(),holder.adapterPosition )
                                response.body()
                                    ?.let { it1 -> updateItem(it1,holder.adapterPosition ) }
                            }
                            override fun onFailure(call: Call<Phone>, t: Throwable) {

                            }

                        }) //retrofit.update

                    }

                }) //setPositiveButton
                setNegativeButton("닫기",null)
                show()
            }
        }

        // 삭제(롱클릭)
        holder.itemView.setOnLongClickListener {
            AlertDialog.Builder(it.context).run {
                setTitle("정말 삭제할까요?")

                setPositiveButton("삭제", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {

                        PhoneClient.retrofit.deleteById(phone.num).enqueue(object :retrofit2.Callback<Void> {
                            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                                removeItem(holder.adapterPosition)
                            }

                            override fun onFailure(call: Call<Void>, t: Throwable) {
                            }
                        })
                    }
                })

                setNegativeButton("닫기", null)
                show()
            }
            false
        }
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }
}