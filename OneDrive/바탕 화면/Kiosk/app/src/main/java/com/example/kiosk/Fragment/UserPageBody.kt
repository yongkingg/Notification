package com.example.kiosk.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kiosk.Activity.BeverageOrderPage
import com.example.kiosk.Activity.CakeOrderPage
import com.example.kiosk.Activity.CouponPage
import com.example.kiosk.R

class UserPageBody: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view : View =  inflater.inflate(R.layout.userpagebody,container,false)
        initEvent(view)
        return view
    }
    fun initEvent(view:View){
        var orderBtn: Button? = view.findViewById<Button>(R.id.orderBtn)
        orderBtn!!.setOnClickListener{
            var intent = Intent(context, BeverageOrderPage::class.java)
            startActivity(intent)
        }

        var cakeBtn: Button? = view.findViewById<Button>(R.id.cakeBtn)
        cakeBtn!!.setOnClickListener{
            var intent = Intent(context, CakeOrderPage::class.java)
            startActivity(intent)
        }

        var couponBtn: Button? = view.findViewById<Button>(R.id.couponBtn)
        couponBtn!!.setOnClickListener{
            var intent = Intent(context, CouponPage::class.java)
            startActivity(intent)
        }
    }
}
