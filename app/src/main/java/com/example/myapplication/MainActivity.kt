package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIr.setOnClickListener{

            val intent2:Intent = Intent(this, MainActivity2::class.java)
            startActivity(intent2)
        }


        btnIr2.setOnClickListener{

            val intent2:Intent = Intent(this, MainActivity3::class.java)
            startActivity(intent2)
        }

    }
}