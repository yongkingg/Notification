package com.example.kiosk.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kiosk.R

class PayPageBody: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(R.layout.paypagebody,container,false)
        initEvent(view)
        return view
    }

    fun initEvent(view:View){
        var payBtn: Button? = view.findViewById<Button>(R.id.payBtn)
        payBtn!!.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.mainlayout,
                EndPageBody()
            ).commit()

        }
    }
}

