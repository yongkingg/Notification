package com.example.kiosk.Activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.Fragment.PayPageBody
import com.example.kiosk.R

class PayPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)

        var headText = findViewById<TextView>(R.id.textView)
        headText.setText("결제")

        var basketBtn: Button? = findViewById<Button>(R.id.basketBtn)
        basketBtn!!.visibility = View.INVISIBLE

        var fragment = PayPageBody()
        var bundle = Bundle()
        var basketCount = intent.getStringExtra("count")
        for (index in 0 until basketCount!!.toInt()){
            var getMenu = intent.getStringArrayListExtra("menu"+"$index")
            bundle.putStringArrayList("menu"+"$index",getMenu!!)
        }
        bundle.putString("count",basketCount)
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, fragment).commit()

    }
}

