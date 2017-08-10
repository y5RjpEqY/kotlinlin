package com.example.a.kotlinlin

import android.support.v4.app.ListFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
        //adapter.add("add")
        listAdapter = adapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_tab, container, false)
    }
}