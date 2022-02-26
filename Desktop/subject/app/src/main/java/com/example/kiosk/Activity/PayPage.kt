package com.example.kiosk.Activity

import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.Fragment.EndPageBody
import com.example.kiosk.Fragment.PayPageBody
import com.example.kiosk.R
import com.example.kiosk.changeFragment

class PayPage : AppCompatActivity(), changeFragment {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)

        var headText = findViewById<TextView>(R.id.textView)
        headText.setText("결제")


        var backBtn : Button? =findViewById<Button>(R.id.backBtn)
        backBtn!!.visibility = View.INVISIBLE

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
        initEvent()
    }

    override fun signal(cost:Int,payment:String,receipt:Boolean, takeType: String) {
        var fragment = EndPageBody()
        var bundle = Bundle()
        bundle.putInt("cost",cost)
        bundle.putString("payment",payment)
        bundle.putString("takeType",takeType)
        if (receipt == true) {
            bundle.putString("receipt","출력")
        } else {
            bundle.putString("receipt","미출력")
        }
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, fragment).commit()

    }
    fun initEvent(){
        var backBtn : Button? = findViewById<Button>(R.id.backBtn)
        backBtn!!.setOnClickListener{
            finish()
        }
    }
}

