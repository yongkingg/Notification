package com.example.kiosk.Activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.kiosk.Fragment.AccountPageBody
import com.example.kiosk.R

class AccountPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)
        var headText = findViewById<TextView>(R.id.textView)
        headText.setText("로그인")
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, AccountPageBody()).commit()

        initEvent()
    }
    fun initEvent(){
        var backBtn: Button? = findViewById<Button>(R.id.backBtn)
        backBtn!!.setOnClickListener{
            finish()
        }
    }
}
