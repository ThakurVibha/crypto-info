package com.example.cryptoinfo.view.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptoinfo.R
import com.example.cryptoinfo.adapters.OnBoardingAdapter
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {
    var PRIVATE_MODE=0
    var PREF_NAME="onBoarding-screen"
    lateinit var onBoardingAdapter: OnBoardingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref: SharedPreferences = getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        if (sharedPref.getBoolean(PREF_NAME, false)) {
            val homeIntent = Intent(this, CryptoActivity::class.java)
            startActivity(homeIntent)
            finish()
        } else {
            setContentView(R.layout.activity_on_boarding)
            setAdapter()
            val editor = sharedPref.edit()
            editor.putBoolean(PREF_NAME, true)
            editor.apply()
        }
    }

    private fun setAdapter() {
        onBoardingAdapter= OnBoardingAdapter()
        viewPager.adapter=onBoardingAdapter

    }
}