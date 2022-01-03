package com.example.cryptoinfo.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cryptoinfo.R
import com.example.cryptoinfo.view.fragments.CalculatorFragment
import com.example.cryptoinfo.view.fragments.CurrencyFragment
import kotlinx.android.synthetic.main.activity_crypto.*

class CryptoActivity : AppCompatActivity() {

    var currencyFragment = CurrencyFragment()
    var calculatorFragment = CalculatorFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto)
        supportFragmentManager.beginTransaction().replace(R.id.container, currencyFragment).commit()
        selectFragment()

    }

    private fun selectFragment() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.calculator ->
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, calculatorFragment).commit()

                R.id.crypto ->
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, currencyFragment).commit()
            }
            true
        }

    }
}