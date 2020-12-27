package com.olgatech.droidcampfinals

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {

    private val  TIME_OUT = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_activity)

        Handler().postDelayed({ // This method will be executed once the timer is over
            // Start app main activity
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, TIME_OUT.toLong())
    }
}