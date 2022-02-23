package com.example.kiosk.Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.DataInterface
import com.example.kiosk.Fragment.BeverageOrderPageBody
import com.example.kiosk.R

class BeverageOrderPage : AppCompatActivity(), DataInterface {
    lateinit var getBeverageValue: ActivityResultLauncher<Intent>
    var basket = mutableListOf<ArrayList<String>>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, BeverageOrderPageBody()).commit()
        var headText = findViewById<TextView>(R.id.textView)
        headText.setText("음료주문")

        getBeverageValue = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(), ActivityResultCallback<ActivityResult>(){
                if (it.resultCode == Activity.RESULT_CANCELED) {
                    var beverageName = it.data?.getStringExtra("name")
                    var beverageImage = it.data?.getStringExtra("Image")
                    var beverageCost = it.data?.getStringExtra("cost")
                    var beverageCount = it.data?.getStringExtra("count")
                    var beverageTemp = it.data?.getStringExtra("temp")
                    var beverageSize = it.data?.getStringExtra("size")
                    var beverageReceive = it.data?.getStringExtra("receive")

                    var beverageTopping = it.data?.getIntegerArrayListExtra("topping")
                    var chocolate = beverageTopping?.get(0).toString()
                    var cream = beverageTopping?.get(1).toString()
                    var pull = beverageTopping?.get(2).toString()
                    var shirup = beverageTopping?.get(3).toString()

                    if (beverageName != null && beverageCount != null && beverageTemp != null && beverageSize != null && beverageReceive != null) {
                        basket.add(arrayListOf(beverageName!!,beverageImage!!,beverageCost!!,beverageCount!!,beverageTemp!!,beverageSize!!,beverageReceive!!,chocolate,cream,pull,shirup))
                    }

                } else if (it.resultCode == Activity.RESULT_OK){
                    var basketCount = it.data?.getStringExtra("length")
                    basket = mutableListOf<ArrayList<String>>()
                    for (index in 0 until basketCount!!.toInt()) {
                        var menu = it.data?.getStringArrayListExtra("value"+"$index")
                        basket.add(menu!!)
                    }
                } else if (it.resultCode == Activity.RESULT_FIRST_USER){
                    basket = mutableListOf<ArrayList<String>>()
                }
            }
        )
        var getBasketCount = intent?.getStringExtra("length")
        if (getBasketCount != null) {
            for (index in 0 until getBasketCount!!.toInt()){
                var menu = intent?.getStringArrayListExtra("value"+"$index")
                basket.add(menu!!)
            }
        }
        Log.d("tag","$basket")
        initEvent()
    }

    fun initEvent(){
        var backBtn:Button? = findViewById<Button>(R.id.backBtn)
        backBtn!!.setOnClickListener{
            var intent = Intent(this, StartPage::class.java)
            if (basket.count() != 0) {
                intent.putExtra("menuCount","${basket.count()}")
                for (index in 0 until basket.count()){
                    intent.putStringArrayListExtra("menu" + "$index",basket[index])
                }
            }
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
        var basketBtn:Button? = findViewById<Button>(R.id.basketBtn)
        basketBtn!!.setOnClickListener{
            var intent = Intent(this, BasketPage::class.java)
            if (basket.count() == 0){
                startActivity(intent)
            } else {
                for (index in 0 until basket.count()) {
                    intent.putStringArrayListExtra("value"+"$index",basket[index])
                }
                intent.putExtra("length",basket.count().toString())
                getBeverageValue.launch(intent)
            }
        }
    }

    override fun sendSignal(index:Int,category:Int) {
        var intent = Intent(this, BeverageSetPage::class.java)
        intent.putExtra("menu","$index")
        intent.putExtra("category","$category")
        getBeverageValue.launch(intent)
    }
}
