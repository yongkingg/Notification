package com.example.kiosk.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kiosk.R

class CouponPageBody: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view : View =  inflater.inflate(R.layout.couponpagebody,container,false)
        requireActivity().supportFragmentManager.beginTransaction().replace(
            R.id.space,
            EmptyCouponBody()
        ).commit()
        initEvent(view)
        return view
    }
    fun initEvent(view:View){
        var usedCouponBtn:Button? = view.findViewById<Button>(R.id.usedCoupon)
        usedCouponBtn!!.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.space,
                UsedCouponBody()
            ).commit()
        }
        var unUsedCouponBtn:Button? = view.findViewById<Button>(R.id.unUsedCoupon)
        unUsedCouponBtn!!.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.space,
                EmptyCouponBody()
            ).commit()
        }
        var setCouponBtn:Button = view.findViewById<Button>(R.id.setCouponBtn)
        setCouponBtn!!.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.mainlayout,
                SetCouponBody()
            ).commit()
        }
    }
}
