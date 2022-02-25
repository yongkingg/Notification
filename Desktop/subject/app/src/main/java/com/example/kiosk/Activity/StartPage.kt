package com.example.kiosk.Activity

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.Dimension
import androidx.core.view.GravityCompat
import androidx.core.view.marginRight
import androidx.drawerlayout.widget.DrawerLayout
import com.example.kiosk.ChangeActivitiy
import com.example.kiosk.DataInterface
import com.example.kiosk.R
import com.example.kiosk.Fragment.StartPageBody
import com.example.kiosk.changeFragment
import java.sql.Array

class StartPage : AppCompatActivity(), ChangeActivitiy, DataInterface {
    var basket : ArrayList<ArrayList<String>> = arrayListOf<ArrayList<String>>()
    lateinit var getBeverageValue: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menubtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, StartPageBody()).commit()

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

                } else if(it.resultCode == RESULT_OK){
                    basket = arrayListOf<ArrayList<String>>()
                    var getBasket = it.data?.getStringExtra("menuCount")
                    if (getBasket != null){
                        for (index in 0 until getBasket!!.toInt()) {
                            var menu = it.data?.getStringArrayListExtra("menu"+"$index")!!
                            basket.add(menu)
                        }
                    }
                }
            }
        )
        initEvent()
    }

    fun initEvent() {
        var drawerLayout : DrawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        var drawerView : View = findViewById<View>(R.id.drawer)

        var basketBtn:Button? = findViewById<Button>(R.id.basketBtn)
        basketBtn!!.setOnClickListener{
            Log.d("tag","$basket")
            var intent = Intent(this, BasketPage::class.java)
            intent.putExtra("length",basket.count().toString())
            for (index in 0 until basket.count()) {
                intent.putStringArrayListExtra("value"+"$index",basket[index])
            }
            startActivity(intent)
        }

        var menuBtn: Button? = findViewById<Button>(R.id.menuBtn)
        menuBtn!!.setOnClickListener{
            drawerLayout.openDrawer(Gravity.LEFT)
        }

        var closeDrawerBtn: Button? = findViewById<Button>(R.id.closeDrawer)
        closeDrawerBtn!!.setOnClickListener{
            drawerLayout.closeDrawer(drawerView)
        }

        var beverageOrderBtn : LinearLayout? = findViewById(R.id.orderBeverage)
        beverageOrderBtn!!.setOnClickListener{
            var intent = Intent(this, BeverageOrderPage::class.java)
            intent.putExtra("length",basket.count().toString())
            for (index in 0 until basket.count()) {
                intent.putStringArrayListExtra("value"+"$index",basket[index])
            }
            Log.d("tag","$basket")
            getBeverageValue.launch(intent)
            drawerLayout.closeDrawer(drawerView)
        }


    }

    override fun signal(dummy:String) {
        if (dummy == "1") {
            var intent = Intent(this, BeverageOrderPage::class.java)
            intent.putExtra("length",basket.count().toString())
            for (index in 0 until basket.count()) {
                intent.putStringArrayListExtra("value"+"$index",basket[index])
            }
            getBeverageValue.launch(intent)
            Log.d("tag","$basket")
        } else if (dummy == "2") {

        }
    }

    override fun sendSignal(data: Int, category: Int) {
        var intent = Intent(this, BeverageSetPage::class.java)
        intent.putExtra("menu","$data")
        intent.putExtra("category","$category")
        getBeverageValue.launch(intent)
    }
}