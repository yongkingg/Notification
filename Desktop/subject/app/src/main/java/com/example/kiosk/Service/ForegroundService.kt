package com.example.kiosk.Service

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.kiosk.Activity.BasketPage
import com.example.kiosk.R

class ForegroundService: Service() {
    var beverageCost : Int = 0
    var menuCount : Int = 0
    lateinit var notificationManager: NotificationManager
    lateinit var builder : NotificationCompat.Builder
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        builder = NotificationCompat.Builder(this, "channel")
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }
// Destory 상태에서 Notification 종료.
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var name = intent?.getStringExtra("name")
        var cost = intent?.getStringExtra("totalCost")
        var count = intent?.getStringExtra("count")
        beverageCost += cost!!.toInt()
        menuCount += count!!.toInt()
        startNotification(name!!)
        return super.onStartCommand(intent, flags, startId)
    }

    fun startNotification(name : String) {
        builder
            .setContentTitle("이디야 알림")
            .setContentText("장바구니에 ${name}가 담겼습니다")
            .setSmallIcon(R.drawable.ade)
            .setStyle(NotificationCompat.BigTextStyle().bigText("장바구니에 ${name}가 담겼습니다\n총합 금액 : $beverageCost       음료 개수 : $menuCount"))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var name = "channelname"
            var text = "42142636346"
            var importance = NotificationManager.IMPORTANCE_DEFAULT
            var channel = NotificationChannel("channel", name, importance).apply {
                description = text
            }
            notificationManager.createNotificationChannel(channel)
            notificationManager.notify(0, builder.build())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        notificationManager.cancel(0)
    }
}