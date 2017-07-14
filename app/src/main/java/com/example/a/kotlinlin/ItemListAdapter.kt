package com.example.a.kotlinlin

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

/**
 * Created by a on 2017/07/14.
 */
class ItemListAdapter(context:Context) : ArrayAdapter<String>(context,0){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return super.getView(position, convertView, parent)
    }

}