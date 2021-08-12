package com.example.messagereciever

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNotificationChannel()
    }


        @SuppressLint("ServiceCast")
        private fun initNotificationChannel() {
            // инициализация канала нотификаций
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notificationManager: NotificationChannel = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationChannel;
                val importance: Int = NotificationManager.IMPORTANCE_LOW;
                val channel  =  NotificationChannel("2", "name", importance);
                notificationManager.let { channel }
            }

    }
}