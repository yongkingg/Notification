package com.example.kiosk.Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.BeverageValue
import com.example.kiosk.Fragment.BeverageSetPageBody
import com.example.kiosk.R
import kotlin.math.cos

class BeverageSetPage : AppCompatActivity(), BeverageValue {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)
        var headText = findViewById<TextView>(R.id.textView)
        headText.setText("음료 주문")
        var fragment = BeverageSetPageBody()
        var bundle = Bundle()
        bundle.putString("menu", intent.getStringExtra("menu"))
        bundle.putString("category",intent.getStringExtra("category"))
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, fragment).commit()
        initEvent()
    }

    fun initEvent(){
        var backBtn: Button? = findViewById<Button>(R.id.backBtn)
        backBtn!!.setOnClickListener{
            finish()
            }
        var basketBtn:Button? = findViewById<Button>(R.id.basketBtn)
        basketBtn!!.setOnClickListener{
            var intent = Intent(this, BasketPage::class.java)
            startActivity(intent)
        }
    }
    override fun sendValue(name: String, Image:Int,cost:Int,count: Int,temp: String,size: String,receive: String,topping: ArrayList<Int>) {
        var intent = Intent(this, BeverageOrderPage::class.java)
        intent.putExtra("name",name)
        intent.putExtra("Image",Image.toString())
        intent.putExtra("cost",cost.toString())
        intent.putExtra("count",count.toString())
        intent.putExtra("temp",temp)
        intent.putExtra("size",size)
        intent.putExtra("receive",receive)
        intent.putIntegerArrayListExtra("topping",topping)
        setResult(Activity.RESULT_CANCELED, intent)
        Log.d("tag", cost.toString())
        finish()
    }
}

