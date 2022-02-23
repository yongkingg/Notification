package com.example.kiosk

interface DataInterface {
    fun sendSignal(data:Int,category:Int)
}

interface BeverageValue {
    fun sendValue(name:String,Image:Int,cost:Int,count:Int,temp:String,size:String,receive:String, topping: ArrayList<Int>)
}

interface DeleteMenu {
    fun sendBasketList(list: ArrayList<ArrayList<String>>)
}

interface changeFragment {
    fun signal()
}
