package com.example.cryptoinfo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoinfo.R
import com.example.cryptoinfo.adapters.CryptoNameAdapter
import com.example.cryptoinfo.utils.Communicator
import com.example.cryptoinfo.viewmodel.CryptoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Communicator {
    lateinit var cryptoViewModel: CryptoViewModel
    lateinit var cryptoNameAdapter: CryptoNameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initApi()
        setObserver()
    }

    private fun initViewModel() {
        cryptoViewModel = ViewModelProvider(this).get(CryptoViewModel::class.java)

    }

    private fun initApi() {
        cryptoViewModel.fetchCryptoData()
    }

    private fun setObserver() {
        progressBar.visibility = View.VISIBLE
        cryptoViewModel.successData().observe(this, Observer {
            cryptoNameAdapter = CryptoNameAdapter(this, it, this )
            rvCrypto.adapter = cryptoNameAdapter
            rvCrypto.layoutManager = LinearLayoutManager(this)
            progressBar.visibility = View.GONE
        })


    }

    override fun onPassingID(id: String) {
        var intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id",id)
        startActivity(intent)
    }


}