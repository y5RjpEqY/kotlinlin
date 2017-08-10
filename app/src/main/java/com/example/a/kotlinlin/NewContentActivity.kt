package com.example.a.kotlinlin

import android.app.DatePickerDialog
import android.app.Notification
import android.app.TimePickerDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.NotificationCompat
import android.util.Log
import android.widget.ArrayAdapter
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
            val builder = NotificationCompat.Builder(applicationContext)
            builder.setSmallIcon(R.mipmap.ic_launcher)
            val manager = NotificationManagerCompat.from(applicationContext)
            builder.setContentTitle("Title") // 1行目
            builder.setContentText("Text") // 2行目
            builder.setSubText("SubText") // 3行目
            builder.setContentInfo("Info") // 右端
            builder.priority = 1
            builder.setWhen(System.currentTimeMillis()) // タイムスタンプ（現在時刻、メール受信時刻、カウントダウンなどに使用）
            builder.setDefaults(Notification.DEFAULT_VIBRATE)
            manager.notify(1, builder.build())
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
