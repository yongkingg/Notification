package com.example.kiosk.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.Fragment.CakeSetPageBody
import com.example.kiosk.R

class CakeSetPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, CakeSetPageBody()).commit()
        var headText = findViewById<TextView>(R.id.textView)
        headText.setText("케이크 주문")
        initEvent()
    }

    fun initEvent() {
        var basketBtn: Button? = findViewById<Button>(R.id.basketBtn)
        basketBtn!!.setOnClickListener{
            var intent = Intent(this, BasketPage::class.java)
            startActivity(intent)
        }
        var backBtn: Button? = findViewById<Button>(R.id.backBtn)
        backBtn!!.setOnClickListener{
            finish()
        }


    }

}
