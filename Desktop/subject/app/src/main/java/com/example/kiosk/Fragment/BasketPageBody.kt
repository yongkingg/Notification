package com.example.kiosk.Fragment

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.kiosk.Activity.PayPage
import com.example.kiosk.DeleteMenu
import com.example.kiosk.R

class BasketPageBody: Fragment() {
    var layout = mutableListOf<LinearLayout>()
    var sql: String = ""

    // getMenu[index][2] => 음료의 총 가격 + 토핑값 계산해야함
    lateinit var deleteMenu: DeleteMenu
    override fun onAttach(context: Context) {
        super.onAttach(context)
        deleteMenu = context as DeleteMenu
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View {
        var view: View = inflater.inflate(R.layout.basketpagebody, container, false)

        var getBasketCount = arguments?.getString("basketCount")
        var basketMenu: ArrayList<ArrayList<String>> = ArrayList()
        for (index in 0 until getBasketCount!!.toInt()) {
            var getMenu = arguments?.getStringArrayList("menu" + "$index")
            basketMenu.add(getMenu!!)
        }

        printBasket(basketMenu, getBasketCount, view)
        deleteMenuEvent(basketMenu, getBasketCount, view)
        payEvent(basketMenu,getBasketCount,view)
        return view
    }

    fun printBasket(basketMenu: ArrayList<ArrayList<String>>, count: String?, view: View) {
        var parentLayout = view.findViewById<LinearLayout>(R.id.basketPageLayout)
        var layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        var imageParams = LinearLayout.LayoutParams(200, LinearLayout.LayoutParams.MATCH_PARENT)
        var textParams = LinearLayout.LayoutParams(410, LinearLayout.LayoutParams.WRAP_CONTENT)

        for (index in 0 until count!!.toInt()) {
            var linearLayout = LinearLayout(context)
            linearLayout.orientation = LinearLayout.HORIZONTAL
            layoutParams.setMargins(10, 0, 10, 0)
            linearLayout.layoutParams = layoutParams
            parentLayout.addView(linearLayout)
            layout.add(linearLayout)

            var image = ImageView(context)
            image.setImageResource(R.drawable.beverage)
            image.layoutParams = imageParams
            image.setImageResource(basketMenu[index][1].toInt())
            linearLayout.addView(image)

            var textLayout = LinearLayout(context)
            textLayout.orientation = LinearLayout.VERTICAL
            textLayout.layoutParams = textParams
            linearLayout.addView(textLayout)

            var name = TextView(context)
            textParams.setMargins(10, 0, 10, 0)
            name.layoutParams = textParams
            name.textSize = 30.0f
            name.setText(basketMenu!![index][0] + "\n X ${basketMenu!![index][3]}")
            name.setTypeface(resources.getFont(R.font.body))
            name.setTextColor(Color.BLACK)
            textLayout.addView(name)

            var temp = TextView(context)
            textParams.setMargins(10, 0, 10, 0)
            temp.layoutParams = textParams
            temp.textSize = 25.0f
            temp.setText(basketMenu!![index][4])
            temp.setTypeface(resources.getFont(R.font.body))
            temp.setTextColor(Color.BLACK)
            textLayout.addView(temp)

            var size = TextView(context)
            textParams.setMargins(10, 0, 10, 0)
            size.layoutParams = textParams
            size.setText(basketMenu[index][5])
            size.textSize = 25.0f
            size.setTypeface(resources.getFont(R.font.body))
            size.setTextColor(Color.BLACK)
            textLayout.addView(size)

            var topping = TextView(context)
            textParams.setMargins(10, 0, 10, 0)
            topping.layoutParams = textParams
            if (basketMenu[index][7].toInt() > 0) {
                sql += "초콜릿칩 X " + "${basketMenu[index][7]}\n"
            }
            if (basketMenu[index][8].toInt() > 0) {
                sql += "휘핑크림 X " + "${basketMenu[index][8]}\n"
            }
            if (basketMenu[index][9].toInt() > 0) {
                sql += "타피오카 펄 X " + "${basketMenu[index][9]}\n"
            }
            if (basketMenu[index][10].toInt() > 0) {
                sql += "시럽 X " + "${basketMenu[index][10]}"
            }
            if (basketMenu[index][7] == "0" && basketMenu[index][8] == "0" && basketMenu[index][9] == "0" && basketMenu[index][10] == "0") {
                sql == "토핑 없음"
            }
            topping.setText(sql)
            topping.textSize = 25.0f
            topping.setTypeface(resources.getFont(R.font.body))
            topping.setTextColor(Color.BLACK)
            textLayout.addView(topping)

            var button = ImageView(context)
            button.id = index
            button.setImageResource(R.drawable.close)

            button.layoutParams = LinearLayout.LayoutParams(100, 100).apply {
                gravity = Gravity.CENTER
            }
            linearLayout.addView(button)
        }
    }

    fun deleteMenuEvent(basketMenu: ArrayList<ArrayList<String>>, count: String?, view: View) {
        for (index in 0 until count!!.toInt()) {
            var parentLayout = view.findViewById<LinearLayout>(R.id.basketPageLayout)
            var deleteMenuBtn: ImageView? = view.findViewById<ImageView>(index)
            deleteMenuBtn!!.setOnClickListener {
                parentLayout.removeView(layout[index])
                basketMenu[index] = ArrayList(0)
                deleteMenu.sendBasketList(basketMenu)
                checkBasket(count,basketMenu,view)
            }
        }
    }

    fun checkBasket(count: String?, basketMenu: ArrayList<ArrayList<String>>, view: View) {
        var checkNull : Int = 0
        for (index in 0 until count!!.toInt()){
            if (basketMenu[index].isNullOrEmpty()) {
                checkNull += 1
                if (checkNull == count.toInt()) {
                    Log.d("tag","!")
                    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.mainlayout,NullBasketPageBody()).commit()
                }
            }
        }
    }

    fun payEvent(basketMenu: ArrayList<ArrayList<String>> ,getBasketCount:String,view: View) {
        var payStart: Button? = view.findViewById<Button>(R.id.payStartBtn)
        payStart!!.setOnClickListener {
            var intent = Intent(context,PayPage::class.java)
            intent.putExtra("count",getBasketCount)
            for (index in 0 until getBasketCount.toInt()){
                intent.putStringArrayListExtra("menu"+"$index",basketMenu[index])
            }
            startActivity(intent)
        }
    }
}




