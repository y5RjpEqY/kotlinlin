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

        var 😀 = 0
        var button = findViewById(R.id.button) as Button
        var textView = findViewById(R.id.tv1) as TextView
        textView.text = 😀.toString()

        button.setOnClickListener { view ->
            😀 ++
            textView.setText(😀.toString())
            Log.d("Test",😀.toString())
        }
    }
}
