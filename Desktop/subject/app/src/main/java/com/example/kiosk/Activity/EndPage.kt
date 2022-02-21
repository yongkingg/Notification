package com.example.kiosk.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.Fragment.EndPageBody
import com.example.kiosk.R

class EndPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menubtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, EndPageBody()).commit()
    }
}
