package com.example.a.kotlinlin

import android.support.v4.app.ListFragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by a on 2017/07/11.
 */
class MainTabFragmentPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): ListFragment {
//        positionによってデータを検索し
//        Listにする
        return ItemListFragment.newInstance()
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "page" + position
    }
}