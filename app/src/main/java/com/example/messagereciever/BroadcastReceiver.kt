package com.example.messagereciever

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat

class BroadcastReceiver : BroadcastReceiver() {

    private val NAME_MSG = "MSG"
    private val TAG = "MessageBroadcastReceiver"
    private var messageId = 0

    // Сюда приходит широковещательное оповещение
    @SuppressLint("LongLogTag")
    override fun onReceive(context: Context, intent: Intent) {
        // Получить параметр сообщения
        val message: String? = intent.getStringExtra(NAME_MSG);

        message?.let { Log.d(TAG, it) };
        // создать нотификацию
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, "2")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Broadcast Receiver")
            .setContentText(message);
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager;
        notificationManager.notify(messageId++, builder.build());
    }
}