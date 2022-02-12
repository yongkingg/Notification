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

class BeverageSetPageBody: Fragment() {
    var beverageCount: Int = 1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view: View = inflater.inflate(R.layout.beveragesetbody, container, false)
        initEvent(view)
        return view
    }

    fun initEvent(view: View) {
        buttonEvent(view)
        beverageCount(view)
    }

    fun beverageCount(view:View){
        var beverageCountView: TextView? = view.findViewById<TextView>(R.id.beverageCount)
        beverageCountView!!.setText(beverageCount.toString())

        var basketBtn: Button? = view.findViewById<Button>(R.id.payBtn)
        basketBtn!!.setOnClickListener {
//            var intent = Intent(context, BeverageOrderPage::class.java)
//            startActivity(intent)
            var popupView = getLayoutInflater().inflate(R.layout.popupwindow, null);
            var alertdialog = AlertDialog.Builder(context).create()
            var popupBackBtn = popupView.findViewById<Button>(R.id.backBtn)
            var popupText = popupView.findViewById<TextView>(R.id.popuptext)
            popupText.setText("장바구니에 음료가 담겼습니다.")
            popupBackBtn!!.setOnClickListener {
                alertdialog.hide()
                requireActivity().finish()
            }
            alertdialog.setView(popupView)
            alertdialog.show()
            alertdialog.window!!.setLayout(600, 400)
        }

        var minusBtn: Button? = view.findViewById<Button>(R.id.minusBtn)
        minusBtn!!.setOnClickListener {
            if (beverageCount == 1) {
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
                beverageCount -= 1
                beverageCountView!!.setText(beverageCount.toString())
            }
        }
        var plusBtn: Button? = view.findViewById<Button>(R.id.plusBtn)
        plusBtn!!.setOnClickListener {
            beverageCount += 1
            beverageCountView!!.setText(beverageCount.toString())
        }
    }

    fun buttonEvent(view:View) {
        var iceBtn: Button? = view.findViewById<Button>(R.id.icebeverageBtn)
        var hotBtn: Button? = view.findViewById<Button>(R.id.hotbeverageBtn)

        iceBtn!!.setOnClickListener {
            iceBtn.setBackgroundResource(R.drawable.accountbtn)
            hotBtn!!.setBackgroundResource(R.drawable.mainbtn)
        }

        hotBtn!!.setOnClickListener {
            iceBtn.setBackgroundResource(R.drawable.mainbtn)
            hotBtn.setBackgroundResource(R.drawable.accountbtn)
        }

        var regularBtn: Button? = view.findViewById<Button>(R.id.regularBtn)
        var largeBtn: Button? = view.findViewById<Button>(R.id.largeBtn)
        var maxBtn: Button? = view.findViewById<Button>(R.id.maxBtn)

        regularBtn!!.setOnClickListener {
            regularBtn.setBackgroundResource(R.drawable.accountbtn)
            largeBtn!!.setBackgroundResource(R.drawable.mainbtn)
            maxBtn!!.setBackgroundResource(R.drawable.mainbtn)
        }
        largeBtn!!.setOnClickListener {
            regularBtn.setBackgroundResource(R.drawable.mainbtn)
            largeBtn!!.setBackgroundResource(R.drawable.accountbtn)
            maxBtn!!.setBackgroundResource(R.drawable.mainbtn)
        }
        maxBtn!!.setOnClickListener {
            regularBtn.setBackgroundResource(R.drawable.mainbtn)
            largeBtn!!.setBackgroundResource(R.drawable.mainbtn)
            maxBtn!!.setBackgroundResource(R.drawable.accountbtn)
        }

        var takeOutBtn: Button? = view.findViewById<Button>(R.id.takeOutBtn)
        var hollBtn: Button? = view.findViewById<Button>(R.id.hollBtn)

        takeOutBtn!!.setOnClickListener {
            takeOutBtn.setBackgroundResource(R.drawable.accountbtn)
            hollBtn!!.setBackgroundResource(R.drawable.mainbtn)
        }
        hollBtn!!.setOnClickListener {
            takeOutBtn.setBackgroundResource(R.drawable.mainbtn)
            hollBtn.setBackgroundResource(R.drawable.accountbtn)
        }
    }
}
