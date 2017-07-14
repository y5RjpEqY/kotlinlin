package com.example.a.kotlinlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.listview_item.view.*

/**
 * Created by a on 2017/07/14.
 */
class ItemListAdapter(context:Context) : ArrayAdapter<String>(context,0){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View
        if (convertView == null){
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.listview_item,parent,false)
        }else{
            view = convertView
        }
        view.item1.text = "ysysy"
        view.item2.text = "item2"
        return view
    }

}