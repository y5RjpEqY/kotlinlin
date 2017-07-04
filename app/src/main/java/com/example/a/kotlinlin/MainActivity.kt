package com.example.a.kotlinlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sum = 0
        var button = findViewById(R.id.button) as Button
        var textView = findViewById(R.id.tv1) as TextView
        textView.text = sum.toString()

        button.setOnClickListener { view ->
            sum ++
            textView.setText(sum.toString())
            Log.d("Test",sum.toString())
        }
    }
}
