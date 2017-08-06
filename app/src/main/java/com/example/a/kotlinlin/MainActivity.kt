package com.example.a.kotlinlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import io.realm.RealmResults

class MainActivity : AppCompatActivity() {
    var mRealm: Realm? = null
    //var todoList = Model()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewの要素を変数に代入
        val editText = findViewById(R.id.text) as EditText
        val listLabel = findViewById(R.id.count) as TextView
        val button = findViewById(R.id.countUpButton) as Button

        //インスタンス取得
        Realm.init(this)
        //val realmConfig = RealmConfiguration.Builder(baseContext).build()
        val realm = Realm.getDefaultInstance()
        mRealm = realm

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
