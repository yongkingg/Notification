package com.example.kiosk.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kiosk.Activity.PayPage
import com.example.kiosk.R

class BasketPageBody: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view : View =  inflater.inflate(R.layout.basketpagebody,container,false)
        initEvent(view)
        return view
    }
    fun initEvent(view: View){
        var payStart : Button? = view.findViewById<Button>(R.id.payStart)
        payStart!!.setOnClickListener{
            var intent = Intent(context, PayPage::class.java)
            startActivity(intent)
        }
    }
}
