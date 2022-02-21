package com.example.kiosk.Fragment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.Dimension
import androidx.fragment.app.Fragment
import com.example.kiosk.Activity.CakeSetPage
import com.example.kiosk.R

class CakeOrderPageBody: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(R.layout.cakeordepagebody,container,false)
        fetchMenu(view)
        initEvent(view)
        return view
    }



    fun fetchMenu(view: View) {
        var menu = resources.getStringArray(R.array.cakeList)
        var parentLayout = view.findViewById<LinearLayout>(R.id.cakeMainLayout)

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val imageParams = LinearLayout.LayoutParams(250, 250)
        imageParams.setMargins(10, 10, 0, 0)

        for (index in 0 until menu.count()) {
            var linearLayout = LinearLayout(context)
            linearLayout.setOrientation(LinearLayout.HORIZONTAL)
            linearLayout.layoutParams = layoutParams
            parentLayout.addView(linearLayout)

            var cakeImage = Button(context)
            cakeImage.id = index
            cakeImage.setBackgroundResource(R.drawable.cake)
            cakeImage.layoutParams = imageParams
            linearLayout.addView(cakeImage)

            var textLayout = LinearLayout(context)
            textLayout.setOrientation(LinearLayout.VERTICAL)
            linearLayout.layoutParams = layoutParams
            linearLayout.addView(textLayout)

            var cakeName = TextView(context)
            cakeName.setText(menu[index])
            cakeName.setTextSize(Dimension.SP, 20.0f)
            cakeName.setTextColor(Color.BLACK)
            cakeName.setPadding(10, 50, 0, 0)
            textLayout.addView(cakeName)

            var cakeCost = TextView(context)
            cakeCost.setText("6300")
            cakeCost.setTextSize(Dimension.SP, 20.0f)
            cakeCost.setTextColor(Color.BLACK)
            cakeCost.setPadding(10, 50, 0, 0)
            textLayout.addView(cakeCost)
        }
    }

    fun initEvent(view:View){
        var menu = resources.getStringArray(R.array.cakeList)
        for (index in 0 until menu.count()){
            var tmpBtn: Button? = view.findViewById<Button>(index)
            tmpBtn!!.setOnClickListener{
                var intent = Intent(context, CakeSetPage::class.java)
                startActivity(intent)
            }
        }
    }
}
