package com.example.kiosk.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kiosk.R
import com.example.kiosk.Fragment.StartPageBody

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menubtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, StartPageBody()).commit()
        initEvent()
    }

    fun initEvent() {
        var basketBtn:Button? = findViewById<Button>(R.id.basketBtn)
        basketBtn!!.setOnClickListener{
            var intent = Intent(this, BasketPage::class.java)
            startActivity(intent)
        }
    }

}