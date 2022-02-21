package com.example.kiosk.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.Fragment.CouponPageBody
import com.example.kiosk.R

class CouponPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, CouponPageBody()).commit()
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
