package com.example.cryptoinfo.view

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptoinfo.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startCryptoActivity()
    }

    private fun startCryptoActivity() {
        CoroutineScope(Dispatchers.IO).launch {
            delay(5000)
            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}