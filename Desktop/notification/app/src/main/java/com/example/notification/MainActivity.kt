package com.example.notification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var startBtn : Button? = findViewById<Button>(R.id.startBtn)
        startBtn!!.setOnClickListener{
            start()
            Toast.makeText(applicationContext,"서비스 시작",Toast.LENGTH_SHORT).show()
        }

        var stopBtn : Button? = findViewById<Button>(R.id.stopBtn)
        stopBtn!!.setOnClickListener{
            Toast.makeText(applicationContext,"서비스 시작",Toast.LENGTH_SHORT).show()
            stop()
        }
    }

    fun start() {
        var serviceIntent = Intent(this,MyService::class.java)
        startService(serviceIntent)
    }

    fun stop() {
        var serviceIntent = Intent(this,MyService::class.java)
        stopService(serviceIntent)
    }
    fun makeNotification() {

    }
}