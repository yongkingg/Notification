package com.example.kiosk.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kiosk.Activity.BeverageSetPage
import com.example.kiosk.R

class BeverageOrderPageBody: Fragment() {
    var beverageList = arrayOf<Int>(R.id.coffee1,R.id.coffee2, R.id.coffee3,R.id.coffee4,R.id.coffee5,R.id.coffee6, R.id.coffee7,R.id.coffee8)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view : View =  inflater.inflate(R.layout.categorybody,container,false)
        initEvent(view)
        return view
    }
    fun initEvent(view: View){
        for (index in 0 until beverageList.count()){
            var beverageBtn: Button? = view.findViewById<Button>(beverageList[index])
            beverageBtn!!.setOnClickListener{
                var intent = Intent(context, BeverageSetPage::class.java)
                startActivity(intent)
            }
        }
    }
}
