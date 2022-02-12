package com.example.kiosk.Fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kiosk.R

class CakeSetPageBody: Fragment() {
    var cakeCount: Int = 1
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(R.layout.cakesetpagebody,container,false)
        initEvent(view)
        return view
    }
    fun initEvent(view:View) {
        payEvent(view)
        cakeCountEvent(view)
        buttonEvent(view)
    }

    fun payEvent(view: View) {
        var payBtn: Button? = view.findViewById<Button>(R.id.payBtn)
        payBtn!!.setOnClickListener {
//            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.mainlayout,PayPageBody()).commit()
            var popupView = getLayoutInflater().inflate(R.layout.popupwindow, null);
            var alertdialog = AlertDialog.Builder(context).create()
            var popupBackBtn = popupView.findViewById<Button>(R.id.backBtn)
            var popupText = popupView.findViewById<TextView>(R.id.popuptext)
            popupText.setText("장바구니에 케잌이 담겼습니다.")
            popupBackBtn!!.setOnClickListener {
                alertdialog.hide()
                requireActivity().finish()

            }
            alertdialog.setView(popupView)
            alertdialog.show()
            alertdialog.window!!.setLayout(600, 400)
        }
    }

    fun cakeCountEvent(view:View){
        var minusBtn: Button? = view.findViewById<Button>(R.id.minusBtn)
        var cakeSetTextView: TextView? = view.findViewById<TextView>(R.id.cakeSetTextView)
        minusBtn!!.setOnClickListener {
            if (cakeCount == 1) {
                var popupView = getLayoutInflater().inflate(R.layout.popupwindow, null);
                var alertdialog = AlertDialog.Builder(context).create()
                var popupBackBtn = popupView.findViewById<Button>(R.id.backBtn)
                popupBackBtn!!.setOnClickListener {
                    alertdialog.hide()
                }
                alertdialog.setView(popupView)
                alertdialog.show()
                alertdialog.window!!.setLayout(600, 400)
            } else {
                cakeCount -= 1
                cakeSetTextView!!.setText(cakeCount.toString())
            }
        }
        var plusBtn: Button? = view.findViewById<Button>(R.id.plusBtn)
        plusBtn!!.setOnClickListener {
            cakeCount += 1
            cakeSetTextView!!.setText(cakeCount.toString())
        }
    }


    fun buttonEvent(view:View){
        var regularBtn: Button? = view.findViewById<Button>(R.id.regularBtn)
        var largeBtn: Button? = view.findViewById<Button>(R.id.largeBtn)
        var maxBtn: Button? = view.findViewById<Button>(R.id.maxBtn)
        regularBtn!!.setOnClickListener{
            regularBtn.setBackgroundResource(R.drawable.accountbtn)
            largeBtn!!.setBackgroundResource(R.drawable.mainbtn)
            maxBtn!!.setBackgroundResource(R.drawable.mainbtn)
        }
        largeBtn!!.setOnClickListener{
            regularBtn.setBackgroundResource(R.drawable.mainbtn)
            largeBtn!!.setBackgroundResource(R.drawable.accountbtn)
            maxBtn!!.setBackgroundResource(R.drawable.mainbtn)
        }
        maxBtn!!.setOnClickListener{
            regularBtn.setBackgroundResource(R.drawable.mainbtn)
            largeBtn!!.setBackgroundResource(R.drawable.mainbtn)
            maxBtn!!.setBackgroundResource(R.drawable.accountbtn)
        }

        var takeOutBtn: Button? = view.findViewById<Button>(R.id.takeOutBtn)
        var hollBtn: Button? = view.findViewById<Button>(R.id.hollBtn)
        takeOutBtn!!.setOnClickListener{
            takeOutBtn!!.setBackgroundResource(R.drawable.accountbtn)
            hollBtn!!.setBackgroundResource(R.drawable.mainbtn)
        }
        hollBtn!!.setOnClickListener{
            hollBtn!!.setBackgroundResource(R.drawable.accountbtn)
            takeOutBtn!!.setBackgroundResource(R.drawable.mainbtn)
        }
    }


}



