package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.shashank.sony.fancytoastlib.FancyToast

class Login : AppCompatActivity() {
    private lateinit var data:LoginData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        data = ViewModelProvider(this@Login)[LoginData::class.java]
        val pass = data.password
        val emailCheck = data.email
        var loginCheck = data.checkLogin
        val loginButton = findViewById<Button>(R.id.button)
        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password = findViewById<EditText>(R.id.editTextNumberPassword)
        if(loginCheck){
            val intent = Intent(this, UnitConverter::class.java)
            startActivity(intent)
        }
        loginButton.setOnClickListener {
            if(loginCheck || emailCheck == email.text.toString() && pass == password.text.toString()){
                FancyToast.makeText(this,"Loin Successful",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show()
                loginCheck = true
                val intent = Intent(this, UnitConverter::class.java)
                startActivity(intent)
            } else if(emailCheck != email.text.toString()) {
                FancyToast.makeText(this,"Invalid Email Id",FancyToast.LENGTH_LONG,FancyToast.WARNING,false).show()

            } else {
                FancyToast.makeText(this,"Invalid Password",FancyToast.LENGTH_LONG,FancyToast.ERROR,false).show()

            }
        }
    }
}