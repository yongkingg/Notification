package com.example.kiosk.Fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.kiosk.R
import org.w3c.dom.Text

class PayPageBody: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view : View = inflater.inflate(R.layout.paypagebody,container,false)

        var getBasketCount = arguments?.getString("count")
        var basketMenu: ArrayList<ArrayList<String>> = ArrayList()
        for (index in 0 until getBasketCount!!.toInt()) {
            var getMenu = arguments?.getStringArrayList("menu" + "$index")
            basketMenu.add(getMenu!!)
        }
        Log.d("tag",getBasketCount)
        Log.d("tag","$basketMenu")

        showBasket(view,getBasketCount,basketMenu)
        initEvent(view,getBasketCount,basketMenu)


        return view
    }

    fun showBasket(view:View,getBasketCount : String,basketMenu : ArrayList<ArrayList<String>>){
        var parentLayout = view.findViewById<LinearLayout>(R.id.payPageParentLayout)

        var layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)

        var basicOptionLayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT,4f)

        var optionParams = LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,2f)

        var textParams = LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT,1f)

        var blankParams = LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.MATCH_PARENT, 1f)

        var headTextParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT)
        headTextParams.setMargins(10,30,10,0)

        var headText = TextView(context)
        headText.setText("주문메뉴/혜택")
        headText.setTypeface(resources.getFont(R.font.head))
        headText.setTextColor(Color.BLACK)
        headText.layoutParams = headTextParams
        headText.textSize = 20.0f
        parentLayout.addView(headText)

        for (index in 0 until getBasketCount.toInt()) {
            var mainLayout = LinearLayout(context)
            mainLayout.orientation = LinearLayout.VERTICAL
            layoutParams.setMargins(10,0,10,10)
            mainLayout.layoutParams = layoutParams
            parentLayout.addView(mainLayout)

            var menuName = TextView(context)
            menuName.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            menuName.setText(basketMenu[index][0])
            menuName.textSize = 20.0f
            menuName.setTextColor(Color.BLACK)
            menuName.setTypeface(resources.getFont(R.font.body))
            mainLayout.addView(menuName)

            var basicOptionLayout = LinearLayout(context)
            basicOptionLayout.layoutParams = basicOptionLayoutParams
            basicOptionLayout.orientation = LinearLayout.HORIZONTAL
            mainLayout.addView(basicOptionLayout)

            var basicOption = TextView(context)
            basicOption.layoutParams = optionParams
            basicOption.setText(basketMenu[index][4] + " | " + basketMenu[index][5]  + " | " + basketMenu[index][6])
            basicOption.textSize = 15f
            basicOption.setTypeface(resources.getFont(R.font.body))
            basicOptionLayout.addView(basicOption)

            var blank = View(context)
            blank.layoutParams = blankParams
            basicOptionLayout.addView(blank)

            var costText = TextView(context)
            costText.layoutParams = textParams
            costText.setTypeface(resources.getFont(R.font.body))
            costText.setText(basketMenu[index][2] + "원")
            costText.gravity = Gravity.END
            costText.textSize = 15f
            basicOptionLayout.addView(costText)
//
//            var toppingLayout = LinearLayout(context)
//            toppingLayout.layoutParams = basicOptionLayoutParams
//            toppingLayout.orientation = LinearLayout.HORIZONTAL
        }

    }
    fun initEvent(view: View, getBasketCount: String, basketMenu: ArrayList<ArrayList<String>>){
        var payBtn: Button? = view.findViewById<Button>(R.id.payBtn)
        payBtn!!.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.mainlayout,
                EndPageBody()
            ).commit()

        }
    }
}

