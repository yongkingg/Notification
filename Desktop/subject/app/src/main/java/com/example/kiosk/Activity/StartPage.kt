package com.example.kiosk.Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.drawerlayout.widget.DrawerLayout
import com.example.kiosk.ChangeActivitiy
import com.example.kiosk.DataInterface
import com.example.kiosk.R
import com.example.kiosk.Fragment.StartPageBody

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
//    override fun onStop() {
//        super.onStop()
//        var repo = getSharedPreferences("table",Activity.MODE_PRIVATE)
//        var editor = repo.edit()
//        editor.putInt("count",basket.count())
//        for (index in 0 until basket.count()){
//            editor.putString("menu$index",basket[index].toString())
//        }
//        editor.commit()
//    }
//
//    override fun onStart() {
//        super.onStart()
//        var repo = getSharedPreferences("table",Activity.MODE_PRIVATE)
//        var count = repo.getInt("count",0)
//        for (index in 0 until count) {
//            Log.d("tag",repo.getString("menu$index","")!!)
//        }
//        Log.d("tag","$basket")
//        Log.d("tag","$count")
//    }
//

    fun initEvent() {
        var drawerLayout : DrawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        var drawerView : View = findViewById<View>(R.id.drawer)

        var basketBtn:Button? = findViewById<Button>(R.id.basketBtn)
        basketBtn!!.setOnClickListener{
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

    }

    override fun sendSignal(data: Int, category: Int) {
        var intent = Intent(this, BeverageSetPage::class.java)
        intent.putExtra("menu","$data")
        intent.putExtra("category","$category")
        getBeverageValue.launch(intent)
    }
}