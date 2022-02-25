package com.example.kiosk.Fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.Dimension
import androidx.fragment.app.Fragment
import com.example.kiosk.DataInterface
import com.example.kiosk.ImageData
import com.example.kiosk.R

class BeverageOrderPageBody: Fragment() {
    lateinit var orderBeverage: DataInterface
    lateinit var image: ImageData
    var category: Int? = 0
    var categoryList = arrayOf(R.array.newMenu, R.array.coffeeList, R.array.flatccino, R.array.shakeade)
    var costList = arrayOf(R.array.newMenuCost, R.array.coffeeCost, R.array.flatccinoCost, R.array.shakeadeCost)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        orderBeverage = context as DataInterface
    }

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View {
        var view: View = inflater.inflate(R.layout.categorybody, container, false)
        var parentLayout = view.findViewById<LinearLayout>(R.id.mainLayout)
        setCategory(view, parentLayout)
        return view
    }

    fun setCategory(view: View, layout: LinearLayout) {
        var newMenu = view.findViewById<Button>(R.id.newBeverageBtn)
        newMenu.setBackgroundResource(R.drawable.accountbtn)
        var coffee = view.findViewById<Button>(R.id.coffeeBtn)
        var flatccino = view.findViewById<Button>(R.id.iceFlakeBtn)
        var shake = view.findViewById<Button>(R.id.cakeBtn)
        fetchMenu(view, category!!, layout)

        newMenu.setOnClickListener {
            newMenu.setBackgroundResource(R.drawable.accountbtn)
            coffee.setBackgroundResource(R.drawable.categorybtn)
            flatccino.setBackgroundResource(R.drawable.categorybtn)
            shake.setBackgroundResource(R.drawable.categorybtn)
            if (category != null) {
                layout.removeAllViews()
            }
            category = 0
            fetchMenu(view, category!!, layout)
        }
        coffee.setOnClickListener {
            newMenu.setBackgroundResource(R.drawable.categorybtn)
            coffee.setBackgroundResource(R.drawable.accountbtn)
            flatccino.setBackgroundResource(R.drawable.categorybtn)
            shake.setBackgroundResource(R.drawable.categorybtn)
            if (category != null) {
                layout.removeAllViews()
            }
            category = 1
            fetchMenu(view, category!!, layout)
        }
        flatccino.setOnClickListener {
            newMenu.setBackgroundResource(R.drawable.categorybtn)
            coffee.setBackgroundResource(R.drawable.categorybtn)
            flatccino.setBackgroundResource(R.drawable.accountbtn)
            shake.setBackgroundResource(R.drawable.categorybtn)
            if (category != null) {
                layout.removeAllViews()
            }
            category = 2
            fetchMenu(view, category!!, layout)
        }
        shake.setOnClickListener {
            newMenu.setBackgroundResource(R.drawable.categorybtn)
            coffee.setBackgroundResource(R.drawable.categorybtn)
            flatccino.setBackgroundResource(R.drawable.categorybtn)
            shake.setBackgroundResource(R.drawable.accountbtn)
            if (category != null) {
                layout.removeAllViews()
            }
            category = 3
            fetchMenu(view, category!!, layout)
        }
    }

    fun fetchMenu(view: View, category: Int, parentLayout: LinearLayout) {
        var menu = resources.getStringArray(categoryList[category])
        var menuCost = resources.getIntArray(costList[category])

        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        val imageParams = LinearLayout.LayoutParams(250, 250)
        imageParams.setMargins(10, 10, 0, 0)

        for (index in 0 until menu.count()) {
            var linearLayout = LinearLayout(context)
            linearLayout.orientation = LinearLayout.HORIZONTAL
            linearLayout.layoutParams = layoutParams
            parentLayout.addView(linearLayout)

            var beverageImage = Button(context)
            beverageImage.id = index
            beverageImage.setBackgroundResource(R.drawable.beverage)
            beverageImage.layoutParams = imageParams
            linearLayout.addView(beverageImage)

            var textLayout = LinearLayout(context)
            textLayout.orientation = LinearLayout.VERTICAL
            linearLayout.layoutParams = layoutParams
            linearLayout.addView(textLayout)

            var beverageName = TextView(context)
            beverageName.setText(menu[index])
            beverageName.setTextSize(Dimension.SP, 20.0f)
            beverageName.setTextColor(Color.BLACK)
            beverageName.setPadding(10, 50, 0, 0)
            textLayout.addView(beverageName)

            var beverageCost = TextView(context)
            beverageCost.setText(menuCost[index].toString())
            beverageCost.setTextSize(Dimension.SP, 20.0f)
            beverageCost.setTextColor(Color.BLACK)
            beverageCost.setPadding(10, 50, 0, 0)
            textLayout.addView(beverageCost)
        }
        image = ImageData()
//
        for (index in 0 until menu.count()) {
            var menuImage = view.findViewById<Button>(index)
            menuImage.setBackgroundResource(image.image[category][index])
        }
        initEvent(view,category)
    }

        fun initEvent(view: View,category: Int) {
            var menu = resources.getStringArray(categoryList[category])
            for (index in 0 until menu.count()) {
                var beverageBtn: Button? = view.findViewById<Button>(index)
                beverageBtn!!.setOnClickListener {
                    orderBeverage.sendSignal(index,category)
                }
            }
        }
    }




