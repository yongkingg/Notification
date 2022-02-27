package com.example.kiosk.Service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
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
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("ta11123123213123123","Start")

        var name = intent?.getStringExtra("name")
        startNotification(name!!)

        return super.onStartCommand(intent, flags, startId)
    }

    fun startNotification(name : String) {
        var builder = NotificationCompat.Builder(this, "channel")
            .setContentTitle("이디야 알림")
            .setContentText("장바구니에 ${name}가 담겼습니다")
            .setSmallIcon(R.drawable.ade)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var name = "channelname"
            var text = "42142636346"
            var importance = NotificationManager.IMPORTANCE_DEFAULT
            var channel = NotificationChannel("channel", name, importance).apply {
                description = text
            }
            var notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.notify(0, builder.build())

        }
    }
}