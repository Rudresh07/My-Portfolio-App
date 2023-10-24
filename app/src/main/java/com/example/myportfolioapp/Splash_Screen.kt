package com.example.myportfolioapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            // Create an Intent to start the next activity (replace NextActivity::class.java with the actual next activity)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close the current splash activity
        }, 3000) // 3000 milliseconds = 3 seconds
    }
}