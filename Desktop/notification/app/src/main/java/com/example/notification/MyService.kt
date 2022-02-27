package com.example.notification

import android.app.*
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MyService: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        myNotification()
        return super.onStartCommand(intent, flags, startId)
    }




    fun myNotification() {
        var builder = NotificationCompat.Builder(this,"channel")
            .setContentTitle("channel")
            .setContentText("12121212")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setStyle(NotificationCompat.BigTextStyle().bigText("Much longer text that cannot fit one line"))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        var intent = Intent(this,MainActivity::class.java)
        var pending = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_CANCEL_CURRENT)
        builder.setContentIntent(pending)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var name = "channelname"
            var text = "42142636346"
            var importance = NotificationManager.IMPORTANCE_DEFAULT
            var channel = NotificationChannel("id",name,importance).apply {
                description = text
            }
            var notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.notify(0,builder.build())
        }





    }
}