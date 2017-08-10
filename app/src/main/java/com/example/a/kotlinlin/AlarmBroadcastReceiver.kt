package com.example.a.kotlinlin

import android.app.Notification
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationManagerCompat
import android.support.v7.app.NotificationCompat

/**
 * Created by a on 2017/08/10.
 */
class AlarmBroadcastReceiver : BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent?) {
        val bid = intent!!.getIntExtra("intentID",0)
        val intent2 = Intent(context,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context,bid,intent2,0)

        val builder = NotificationCompat.Builder(context)

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Title") // 1行目
                .setContentText("Text") // 2行目
                .setSubText("SubText") // 3行目
                .setContentInfo("Info") // 右端
                .setPriority(1)
                .setWhen(System.currentTimeMillis()) // タイムスタンプ（現在時刻、メール受信時刻、カウントダウンなどに使用）
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(pendingIntent)

        val manager = NotificationManagerCompat.from(context)

        manager.notify(1, builder.build())
    }
}