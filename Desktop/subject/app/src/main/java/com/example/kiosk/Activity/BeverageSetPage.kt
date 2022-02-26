package com.example.kiosk.Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
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
        basketBtn!!.visibility = View.INVISIBLE
    }
    override fun sendValue(name: String, Image:Int,cost:Int,count: Int,temp: String,size: String,receive: String,topping: ArrayList<Int>) {
        var beverageOrderPage = Intent(this, BeverageOrderPage::class.java)
        beverageOrderPage.putExtra("name",name)
        beverageOrderPage.putExtra("Image",Image.toString())
        beverageOrderPage.putExtra("cost",cost.toString())
        beverageOrderPage.putExtra("count",count.toString())
        beverageOrderPage.putExtra("temp",temp)
        beverageOrderPage.putExtra("size",size)
        beverageOrderPage.putExtra("receive",receive)
        beverageOrderPage.putIntegerArrayListExtra("topping",topping)
        setResult(Activity.RESULT_CANCELED, beverageOrderPage)

        var startPage = Intent(this,StartPage::class.java)
        startPage.putExtra("name",name)
        startPage.putExtra("Image",Image.toString())
        startPage.putExtra("cost",cost.toString())
        startPage.putExtra("count",count.toString())
        startPage.putExtra("temp",temp)
        startPage.putExtra("size",size)
        startPage.putExtra("receive",receive)
        startPage.putIntegerArrayListExtra("topping",topping)
        setResult(Activity.RESULT_CANCELED, startPage)
        finish()
    }
}

