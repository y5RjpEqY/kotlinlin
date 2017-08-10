package com.example.a.kotlinlin

import android.app.*
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_new_content.*
import java.util.*

class NewContentActivity : AppCompatActivity() {
    var year = 0
    var month = 0
    var day = 0
    var hour = 0
    var minute = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_content)

        date_btn.setOnClickListener{
            val newFragment = DatePick.newInstance()
            newFragment.setListener(DatePickerDialog.OnDateSetListener{ _ , year_tmp , month_tmp , day_tmp ->
//                TODO 直接Modelに突っ込んだほうがいいのかな
                year = year_tmp
                month = month_tmp + 1
                day = day_tmp
                Log.w("date test","year = "+ year + " month = "+ month + " day = " + day)
                date_tv.text = "" + year + "/" + month + "/" + day
            })
            newFragment.show(supportFragmentManager, "datePicker")
        }

        time_btm.setOnClickListener{
            val newFragment = TimePick.newInstance()
            newFragment.setListener(TimePickerDialog.OnTimeSetListener{ _ , hour_tmp , minute_tmp ->
                hour = hour_tmp
                minute = minute_tmp
                Log.w("time test","hour = "+ hour + " minute = "+ minute)
                time_tv.text = "" + hour + ":" + String.format("%02d",minute)
            })
            newFragment.show(supportFragmentManager, "timePicker")
        }

        add_btn.setOnClickListener{
//            TODO 各データのバリデーション後、Realmオブジェクトに保存
//            FIXME 以下、通知テスト
            val calendar = Calendar.getInstance()
            // 過去の時間は即実行されます
//            TODO よしなに時間変更
            calendar.add(Calendar.SECOND, 10)

            val intent = Intent(applicationContext, AlarmBroadcastReceiver::class.java)
            intent.putExtra("intentId", 2)
            val pending = PendingIntent.getBroadcast(applicationContext, 2 , intent, 0)

            // アラームをセットする
            val am = getSystemService(ALARM_SERVICE) as AlarmManager
//            TODO APIに応じて場合分け
            am.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pending)
        }

        createSpinner()
        createAlarmSpinner()
    }

    private fun createSpinner(){
        var list = ArrayList<String>()
//        TODO Tagオブジェクトから取得
        list.add("選択項目: 1")
        list.add("選択項目: 2")
        list.add("選択項目: 3")
        list.add("選択項目: 4")
        list.add("選択項目: 5")

        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list)
        spinner.adapter = adapter

    }

    private fun createAlarmSpinner(){
        var list = ArrayList<String>()
//        TODO 任意の時間にしたいよね
        list.add("5分前")
        list.add("10分前")
        list.add("30分前")
        list.add("1時間前")
        list.add("1日前")

        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,list)
        spinner_alarm.adapter = adapter

    }

}
