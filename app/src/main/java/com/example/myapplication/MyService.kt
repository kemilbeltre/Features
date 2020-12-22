package com.example.myapplication

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Handler
import android.os.IBinder
import android.widget.Toast
import java.util.*


class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        // Send a notification that service is started
        Toast.makeText(getApplicationContext(),"Service started", Toast.LENGTH_SHORT).show();
        return Service.START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(getApplicationContext(),"Service destroyed.", Toast.LENGTH_SHORT).show();
    }
}