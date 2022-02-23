package com.example.kiosk.Activity

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
import com.example.kiosk.R
import com.example.kiosk.Fragment.StartPageBody
import com.example.kiosk.changeFragment
import java.sql.Array

class StartPage : AppCompatActivity(), ChangeActivitiy {
    var basket : ArrayList<ArrayList<String>> = arrayListOf<ArrayList<String>>()
    lateinit var getBeverageValue: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menubtn_fragment)
        supportFragmentManager.beginTransaction().replace(R.id.mainlayout, StartPageBody()).commit()

        getBeverageValue = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(), ActivityResultCallback<ActivityResult>(){
                if(it.resultCode == RESULT_OK){
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
        var intent = Intent(this, BeverageOrderPage::class.java)
        intent.putExtra("length",basket.count().toString())
        for (index in 0 until basket.count()) {
            intent.putStringArrayListExtra("value"+"$index",basket[index])
        }
        getBeverageValue.launch(intent)
        Log.d("tag","$basket")

    }
}