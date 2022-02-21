package com.example.kiosk.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kiosk.Activity.UserPage
import com.example.kiosk.R

class EndPageBody: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view : View =  inflater.inflate(R.layout.endpagebody,container,false)
        initEvent(view)
        return view
    }

    fun initEvent(view:View){
        var backMainBtn:Button = view.findViewById<Button>(R.id.backMain)
        backMainBtn!!.setOnClickListener{
        var intent = Intent(context, UserPage::class.java)
            startActivity(intent)
        }
    }
}


