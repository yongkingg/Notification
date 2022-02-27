package com.example.kiosk.Activity

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.DeleteMenu
import com.example.kiosk.Fragment.BasketPageBody
import com.example.kiosk.Fragment.NullBasketPageBody
import com.example.kiosk.R
import org.w3c.dom.Text

class BasketPage : AppCompatActivity(), DeleteMenu {
    lateinit var getMenu : MutableList<ArrayList<String>>
    var basketChanged : Boolean = false
    var getBasketCount : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.backbtn_fragment)

        var basketBtn:Button? = findViewById<Button>(R.id.basketBtn)
        basketBtn!!.visibility = View.INVISIBLE

        var fragment = BasketPageBody()
        var bundle = Bundle()
        getBasketCount = intent?.getStringExtra("length")


        if (getBasketCount == null || getBasketCount!!.toInt() == 0) {
            supportFragmentManager.beginTransaction().replace(R.id.mainlayout,NullBasketPageBody()).commit()
        } else {
            for (index in 0 until getBasketCount!!.toInt()){
                var menu = intent?.getStringArrayListExtra("value"+"$index")
                bundle.putStringArrayList("menu" + "$index",menu)
            }
            bundle.putString("basketCount",getBasketCount)
            fragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.mainlayout,fragment).commit()
        }

        var headText = findViewById<TextView>(R.id.textView)
        headText.setText("장바구니")
        initEvent()
    }

    override fun sendBasketList(list: ArrayList<ArrayList<String>>) {
        getMenu = list
        basketChanged = true
    }

    fun initEvent(){
        var backBtn: Button? = findViewById<Button>(R.id.backBtn)
        backBtn!!.setOnClickListener{
            if (basketChanged == false){
                finish()
            } else if (basketChanged == true) {
                var intent = Intent(this,BeverageOrderPage::class.java)
                for (index in 0 until getMenu.count()) {
                    getMenu.remove(ArrayList(0))
                }
                if (getMenu.count() == 0){
                    setResult(Activity.RESULT_FIRST_USER)
                    basketChanged = false
                    finish()
                } else {
                    for (index in 0 until getMenu.count()){
                        intent.putStringArrayListExtra("value"+"$index",getMenu[index])
                    }
                    intent.putExtra("length","${getMenu.count()}")
                    setResult(Activity.RESULT_OK,intent)
                    basketChanged = false
                    finish()
                }
            }
        }
    }
}

