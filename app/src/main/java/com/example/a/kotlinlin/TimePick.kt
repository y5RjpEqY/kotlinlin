package com.example.a.kotlinlin

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import java.util.*

/**
 * Created by a on 2017/07/27.
 */
class TimePick : DialogFragment() {
    private lateinit var listener: TimePickerDialog.OnTimeSetListener

    companion object {
        fun newInstance(): TimePick {
            val TimePickFragment = TimePick()
            return TimePickFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        return TimePickerDialog(activity,listener,hour,minute,true)
    }

    fun setListener(listener: TimePickerDialog.OnTimeSetListener){
        this.listener = listener
    }
}