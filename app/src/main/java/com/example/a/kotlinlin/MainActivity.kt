package com.example.a.kotlinlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import io.realm.Realm
import io.realm.RealmChangeListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mRealm: Realm
    var addTodoListener: RealmChangeListener<Realm>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //realm
        Realm.init(this)
        val realm = Realm.getDefaultInstance()
        mRealm = realm

        tabLayout.setupWithViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }
        })

        val manager = supportFragmentManager
        val pagerAdapter = MainTabFragmentPagerAdapter(manager)
        viewPager.adapter = pagerAdapter

        floatingActionButton.setOnClickListener{
            val intent = Intent(this,NewContentActivity::class.java)
            startActivity(intent)
        }




    }

}
