package com.example.firstapp

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception

class SplashScreen : AppCompatActivity() {
    private lateinit var loginCheck:LoginData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        loginCheck = ViewModelProvider(this)[LoginData::class.java]

        // Without Loading splash Page

        Handler(Looper.getMainLooper()).postDelayed({
            if(loginCheck.checkLogin){
                startActivity(Intent(this,UnitConverter::class.java))
            }else {
                startActivity(Intent(this, Login::class.java))
            }
        },3000)

//        longTask() // with Loading splash screen
    }
    fun longTask(){
        LongOperation().execute()
    }
    private open inner class LongOperation : AsyncTask<String?,Void?,String?>(){
        override fun doInBackground(vararg p0: String?): String? {
            for(i in 0..10){
                try {
                    Thread.sleep(1000)
                }catch (e:Exception){
                    Thread.interrupted()
                }
            }
            return "Result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            startActivity(Intent(this@SplashScreen, Login::class.java))
        }

    }
}



