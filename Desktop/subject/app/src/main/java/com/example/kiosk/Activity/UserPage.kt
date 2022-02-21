package com.example.kiosk.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.R
import com.example.kiosk.Fragment.UserPageBody

class UserPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menubtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, UserPageBody()).commit()
    }
}

