package com.example.kiosk.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kiosk.Activity.CakeSetPage
import com.example.kiosk.R

class CakeOrderPageBody: Fragment() {
    var cakeId = arrayOf<Int>(R.id.cake1, R.id.cake2, R.id.cake3, R.id.cake4, R.id.cake5)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(R.layout.cakeordepagebody,container,false)
        initEvent(view)
        return view
    }
    fun initEvent(view:View){
        for (index in 0 until cakeId.count()){
            var tmpBtn: Button? = view.findViewById<Button>(cakeId[index])
            tmpBtn!!.setOnClickListener{
                var intent = Intent(context, CakeSetPage::class.java)
                startActivity(intent)
            }
        }
    }
}
