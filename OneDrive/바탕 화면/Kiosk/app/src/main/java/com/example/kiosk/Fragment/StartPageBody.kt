package com.example.kiosk.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kiosk.Activity.AccountPage
import com.example.kiosk.Activity.CakeSetPage
import com.example.kiosk.R

class StartPageBody: Fragment() {
    var cakeId = arrayOf<Int>(
        R.id.cake1,
        R.id.cake2,
        R.id.cake3,
        R.id.cake4,
        R.id.cake5,
        R.id.cake6,
        R.id.cake7,
        R.id.cake8
    )
    override fun onCreateView(inflater:LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view : View =  inflater.inflate(R.layout.startpagebody,container,false)
        initEvent(view)
        return view
    }
    fun initEvent(view:View){
        var accountBtn: Button? = view.findViewById<Button>(R.id.accountBtn)
        accountBtn!!.setOnClickListener{
            var intent = Intent(context, AccountPage::class.java)
            startActivity(intent)
        }

        for (index in 0 until cakeId.count()) {
            var cakeBtn: Button? = view.findViewById<Button>(cakeId[index])
            cakeBtn!!.setOnClickListener{
                var intent = Intent(context, CakeSetPage::class.java)
                startActivity(intent)
            }

        }
    }
}