package com.example.kiosk.Activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.Fragment.BasketPageBody
import com.example.kiosk.R

class BasketPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, BasketPageBody()).commit()
        var headText = findViewById<TextView>(R.id.textView)
        headText.setText("장바구니")
    }
}

