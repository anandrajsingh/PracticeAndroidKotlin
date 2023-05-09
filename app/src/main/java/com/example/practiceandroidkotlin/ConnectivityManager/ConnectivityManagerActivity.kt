package com.example.practiceandroidkotlin.ConnectivityManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.practiceandroidkotlin.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ConnectivityManagerActivity : AppCompatActivity() {

    private lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_connectivity_manager)

        dialog = MaterialAlertDialogBuilder(this, R.style.MaterialAlertDialog_Rounded)
            .setView(R.layout.custom_dialog_layout)
            .setCancelable(false)
            .create()

        val networkManager = NetworkManager(this)
        networkManager.observe(this){
            if(it){
                if(!dialog.isShowing) dialog.show()
            }else{
                if(dialog.isShowing) dialog.hide()
            }
        }
    }
}