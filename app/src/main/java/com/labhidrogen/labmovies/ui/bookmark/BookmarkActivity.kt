package com.labhidrogen.labmovies.ui.bookmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.labhidrogen.labmovies.R
import com.labhidrogen.labmovies.databinding.ActivityBookmarkBinding

class BookmarkActivity : AppCompatActivity() {
    private var _binding: ActivityBookmarkBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ViewPager2
        val pagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = binding.bookmarkVp
        viewPager.adapter = pagerAdapter
        //tabs
        val tabs = binding.bookmarkTabs
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f

        supportActionBar?.title = resources.getString(R.string.bookmark)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object {
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tv_shows)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}