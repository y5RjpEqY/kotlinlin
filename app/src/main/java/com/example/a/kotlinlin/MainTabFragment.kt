package com.example.a.kotlinlin

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by a on 2017/07/11.
 */
class MainTabFragment : Fragment() {

    companion object {
        fun newInstance() : MainTabFragment {
            val mainTabFragment = MainTabFragment()
            return mainTabFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_tab, container, false)
    }

}