package com.example.myapplication

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity(), AdapterView .OnItemClickListener{
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var runnable:Runnable
    private var handler: Handler = Handler()
    private var pause:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        Toast.makeText(this, "Welcome to ACTIVITY 3", Toast.LENGTH_SHORT)
        mediaPlayer = MediaPlayer.create(this, R.raw.soul)



        // Variable to hold service class name
        val serviceClass = MyService::class.java

        // Initialize a new Intent instance
        val intent = Intent(applicationContext, serviceClass)

        button11.setOnClickListener{

            val intent6: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent6)
        }



        // Button to start the service
        start.setOnClickListener{

            // If the service is not running then start it
            if (!isServiceRunning(serviceClass)) {
                // Start the service
                startService(intent)
                mediaPlayer.start()
                Toast.makeText(this,"media playing",Toast.LENGTH_SHORT).show()


            } else {
                Toast.makeText(this,"Service already running.",Toast.LENGTH_SHORT).show()
                mediaPlayer.start()

            }


        }
        button_pause.setOnClickListener{
            if (mediaPlayer.isPlaying)
            mediaPlayer.pause()else{
                Toast.makeText(this,"Mediaplayer is pause.",Toast.LENGTH_SHORT).show()

            }

        }


        // Button to stop the service
        stopserv.setOnClickListener{
            // If the service is not running then start it
            if (isServiceRunning(serviceClass)) {
                // Stop the service
                stopService(intent)
                mediaPlayer.stop()
                mediaPlayer.reset()
                mediaPlayer.release()
            } else {
                Toast.makeText(this,"Service already stopped.",Toast.LENGTH_SHORT).show()
            }
        }



        // Get the service status
        button_stats.setOnClickListener{
            if (isServiceRunning(serviceClass)) {
                Toast.makeText(this,"Service is running.",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"Service  stopped.",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun initializeSeekBar() {
        TODO("Not yet implemented")
    }


    // Custom method to determine whether a service is running
    private fun isServiceRunning(serviceClass: Class<*>): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        // Loop through the running services
        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                // If the service is running then return true
                return true
            }
        }
        return false
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }


}