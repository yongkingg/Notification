package com.example.kiosk.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.Fragment.PayPageBody
import com.example.kiosk.R

class PayPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, PayPageBody()).commit()
    }
}

