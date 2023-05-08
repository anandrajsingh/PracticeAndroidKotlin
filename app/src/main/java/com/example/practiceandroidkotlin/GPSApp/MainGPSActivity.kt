package com.example.practiceandroidkotlin.GPSApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.practiceandroidkotlin.R

class MainGPSActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_gpsactivity)

        val gpsStatusListener = GpsStatusListener(this)
        val turnOnGps = TurnOnGps(this)
        var isGpsStatusChanged : Boolean? = null
        gpsStatusListener.observe(this){isGpsOn ->
                if(isGpsStatusChanged == null){
                    if(!isGpsOn){
                        turnOnGps.startGps(resultLauncher)
                    }
                    isGpsStatusChanged = isGpsOn
                }else {
                    if(isGpsStatusChanged != isGpsOn) {
                        if(!isGpsOn){
                            turnOnGps.startGps(resultLauncher)
                        }
                    }
                    isGpsStatusChanged = isGpsOn
                }
            }
    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()){activityResult->

        if (activityResult.resultCode == RESULT_OK){
            Toast.makeText(this, "GPS is on", Toast.LENGTH_SHORT).show()
        }else if (activityResult.resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Request is Canceled", Toast.LENGTH_SHORT).show()
        }
    }
}