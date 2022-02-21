package com.example.kiosk.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.kiosk.Activity.UserPage
import com.example.kiosk.R

class AccountPageBody: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view : View =  inflater.inflate(R.layout.accountpagebody,container,false)
        initEvent(view)
        return view
    }
    fun initEvent(view:View){
        var loginBtn : Button? = view.findViewById<Button>(R.id.loginBtn)
        loginBtn!!.setOnClickListener{
            var intent = Intent(context, UserPage::class.java)
            startActivity(intent)
        }
        var signUpBtn : Button? = view.findViewById<Button>(R.id.signUpBtn)
        signUpBtn!!.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.mainlayout,
                SignUpPageBody()
            ).commit()
        }
        var findIdBtn : Button? = view.findViewById<Button>(R.id.findId)
        findIdBtn!!.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.mainlayout,
                FindIdPageBody()
            ).commit()
        }
        var findPwBtn : Button? = view.findViewById<Button>(R.id.findPW)
        findPwBtn!!.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.mainlayout,
                FindPwPageBody()
            ).commit()
        }
    }
}
