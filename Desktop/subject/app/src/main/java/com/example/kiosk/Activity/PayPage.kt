package com.example.kiosk.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.Fragment.PayPageBody
import com.example.kiosk.R

class PayPage : AppCompatActivity() {
    var basket = mutableListOf<ArrayList<String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, PayPageBody()).commit()

        var basketCount = intent.getStringExtra("count")
        Log.d("tag",basketCount!!)
        for (index in 0 until basketCount.toInt()){
            var getMenu = intent.getStringArrayListExtra("menu"+"$index")
            basket.add(getMenu!!)
        }
        Log.d("tag","$basket")
    }
}

