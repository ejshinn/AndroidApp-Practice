package com.example.study08_1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter2 (val fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    var fragments = listOf<Fragment>(AFragment(), BFragment(), CFragment(), DFragment())

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}