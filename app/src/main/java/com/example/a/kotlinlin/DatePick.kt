package com.example.a.kotlinlin

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import java.util.*


/**
 * Created by a on 2017/07/27.
 */
class DatePick : DialogFragment()  {
    private lateinit var listener: DatePickerDialog.OnDateSetListener

    companion object {
        fun newInstance(): DatePick {
            val DatePickFragment = DatePick()
            return DatePickFragment
        }
    }

    fun setListener(listener: DatePickerDialog.OnDateSetListener){
        this.listener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(activity,listener,year,month,day)
    }
}