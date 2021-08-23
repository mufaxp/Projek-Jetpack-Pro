package com.labhidrogen.labmovies.ui.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun createFragment(position: Int): Fragment {
        return ProgrammeFragment.newInstance(position + 1)
    }

    override fun getItemCount(): Int = 2
}