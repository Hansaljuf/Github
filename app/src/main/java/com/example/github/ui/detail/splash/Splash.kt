package com.example.github.ui.detail.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.github.R
import com.example.github.ui.main.MainActivity

class Splash : AppCompatActivity() {
    private val splashS: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, splashS)

        supportActionBar?.hide()

    }
}