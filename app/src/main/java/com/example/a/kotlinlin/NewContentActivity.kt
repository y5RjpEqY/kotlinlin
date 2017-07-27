package com.example.a.kotlinlin

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_new_content.*

class NewContentActivity : AppCompatActivity() {
    var year = 0
    var month = 0
    var day = 0
    var hour = 0
    var minute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_content)

        datebtn.setOnClickListener{
            val newFragment = DatePick.newInstance()
            newFragment.setListener(DatePickerDialog.OnDateSetListener(fun(_: DatePicker?, year_tmp: Int, month_tmp: Int, day_tmp: Int){
                year = year_tmp
                month = month_tmp + 1
                day = day_tmp
                Log.w("date test","year = "+ year + " month = "+ month + " day = " + day)
            }))
            newFragment.show(supportFragmentManager, "datePicker")
        }

        timebtm.setOnClickListener{
            val newFragment = TimePick.newInstance()
            newFragment.setListener(TimePickerDialog.OnTimeSetListener(fun(_: TimePicker?, hour_tmp: Int, minute_tmp: Int){
                hour = hour_tmp
                minute = minute_tmp
                Log.w("time test","hour = "+ hour + " minute = "+ minute)

            }))
            newFragment.show(supportFragmentManager, "timePicker")
        }

        createSpinner()
    }

    private fun createSpinner(){
        var list = ArrayList<String>()
//        Tagオブジェクトから取得
        list.add("選択項目: 1")
        list.add("選択項目: 2")
        list.add("選択項目: 3")
        list.add("選択項目: 4")
        list.add("選択項目: 5")

        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list)
        spinner.adapter = adapter

    }
}
