package com.example.practiceandroidkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.practiceandroidkotlin.ConnectivityManager.ConnectivityManagerActivity
import com.example.practiceandroidkotlin.GPSApp.MainGPSActivity

class MainActivity : AppCompatActivity() {
    lateinit var btnGPS: Button
    lateinit var btnInternet: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGPS = findViewById(R.id.gps)
        btnGPS.setOnClickListener {
            startActivity(Intent(this, MainGPSActivity::class.java))
        }
        btnInternet = findViewById(R.id.internet)
        btnInternet.setOnClickListener {
            startActivity(Intent(this, ConnectivityManagerActivity::class.java))
        }
        btnGPS = findViewById(R.id.gps)
        btnGPS.setOnClickListener {
            startActivity(Intent(this, MainGPSActivity::class.java))
        }

    }
}