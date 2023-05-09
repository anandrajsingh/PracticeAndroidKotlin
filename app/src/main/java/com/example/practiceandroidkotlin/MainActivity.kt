package com.example.practiceandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.practiceandroidkotlin.GPSApp.MainGPSActivity

class MainActivity : AppCompatActivity() {
    lateinit var btnGPS: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGPS = findViewById(R.id.gps)
        btnGPS.setOnClickListener {
            startActivity(Intent(this, MainGPSActivity::class.java))
        }

    }
}