package com.example.a.kotlinlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import io.realm.*

class MainActivity : AppCompatActivity() {
    lateinit var mRealm: Realm
    var myListener: RealmChangeListener<Realm>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewの要素を変数に代入
        val editText = findViewById(R.id.text) as EditText
        val listLabel = findViewById(R.id.count) as TextView
        val listView = findViewById(R.id.list) as ListView
        val button = findViewById(R.id.countUpButton) as Button

        //インスタンス取得
        Realm.init(this)
        //val realmConfig = RealmConfiguration.Builder(baseContext).build()
        val realm = Realm.getDefaultInstance()
        mRealm = realm

        val todoText: MutableList<String> = mutableListOf("")
        realm.where(Model::class.java).findAll().forEach {
            todoText.add(it.text)
        }
        todoText.removeAt(0)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoText)
        listView.adapter = adapter

        myListener = RealmChangeListener<Realm> {
            //DBが書き換えられたときの処理を以下に書く
            Log.v("change", "change shita")
            val todoText: MutableList<String> = mutableListOf("")
            realm.where(Model::class.java).findAll().forEach {
                todoText.add(it.text)
            }
            todoText.removeAt(0)
            val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoText)
            listView.adapter = adapter
        }
        realm.addChangeListener(myListener)

        button.setOnClickListener {
            //一旦モデルのインスタンスを作成してDBに登録する
            realm.executeTransaction {
                val todoList = Model()
                todoList.text = editText.text.toString()
                //全レコードを検索
                val query: RealmResults<Model> = realm.where(Model::class.java).findAll()
                todoList.id = query.size
                realm.copyToRealm(todoList)
                listLabel.text = todoList.text
                //全データベース数をログで表示
                Log.v("database records", query.size.toString())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mRealm?.close()
    }
}
