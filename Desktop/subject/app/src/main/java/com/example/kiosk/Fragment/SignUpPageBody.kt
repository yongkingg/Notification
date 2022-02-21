package com.example.kiosk.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kiosk.R

class SignUpPageBody: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view : View =  inflater.inflate(R.layout.signuppagebody,container,false)
        return view
    }
}