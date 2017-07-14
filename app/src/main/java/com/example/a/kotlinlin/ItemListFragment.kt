package com.example.a.kotlinlin

import android.app.ListFragment
import android.os.Bundle

/**
 * Created by a on 2017/07/14.
 */
class ItemListFragment : ListFragment(){
    private lateinit var adapter : ItemListAdapter

    companion object {
        fun newInstance() : ItemListFragment {
            val itemListFragment = ItemListFragment()
            return itemListFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ItemListAdapter(activity)
        listAdapter = adapter
    }
}