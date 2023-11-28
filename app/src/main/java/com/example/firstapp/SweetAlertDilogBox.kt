package com.example.firstapp

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog


class SweetAlertDilogBox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sweet_alert_dilog_box)

        val Default = findViewById<Button>(R.id.Default)
        val Warning = findViewById<Button>(R.id.Warning)
        val Success = findViewById<Button>(R.id.Success)
        val Error = findViewById<Button>(R.id.Error)
        val Loading = findViewById<Button>(R.id.Loading)

        Default.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Default DialogBox")
            dialog.setMessage("Default Dialog is showing")

            dialog.setPositiveButton("YES"){DialogInterface,which ->
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
            }
            dialog.setNegativeButton("NO"){DialogInterface,which ->
                Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show()
            }
            dialog.setNeutralButton("Cancel"){DialogInterface,which ->
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            }
            dialog.create()
            dialog.setCancelable(false)
            dialog.show()
        }
        Warning.setOnClickListener {
            SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setConfirmText("Yes,delete it!")
                .show()
        }
        Success.setOnClickListener {
            SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Good job!")
                .setContentText("You clicked the button!")
                .show()
        }
        Error.setOnClickListener {
            SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText("Something went wrong!")
                .show()

        }
        Loading.setOnClickListener {
            val pDialog = SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
            pDialog.progressHelper.barColor = Color.parseColor("#A5DC86")
            pDialog.titleText = "Loading"
            pDialog.setCancelable(false)
            pDialog.show()
            val handler:Handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                pDialog.dismiss()
            },5000)
        }
    }

}