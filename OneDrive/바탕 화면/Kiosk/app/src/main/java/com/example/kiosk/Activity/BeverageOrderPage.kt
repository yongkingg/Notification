package com.example.kiosk.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.Fragment.BeverageOrderPageBody
import com.example.kiosk.R

class BeverageOrderPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, BeverageOrderPageBody()).commit()
        var headText = findViewById<TextView>(R.id.textView)
        headText.setText("음료주문")
        initEvent()
    }
    fun initEvent(){
        var backBtn:Button? = findViewById<Button>(R.id.backBtn)
        backBtn!!.setOnClickListener{
            finish()
        }
        var basketBtn:Button? = findViewById<Button>(R.id.basketBtn)
        basketBtn!!.setOnClickListener{
            var intent = Intent(this, BasketPage::class.java)
            startActivity(intent)
        }
    }
}
