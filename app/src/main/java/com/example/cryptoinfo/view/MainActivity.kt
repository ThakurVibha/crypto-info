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
import com.example.cryptoinfo.utils.Constants.isInternetAvailable
import com.example.cryptoinfo.utils.Constants.showSnackBar
import com.example.cryptoinfo.viewmodel.CryptoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnInternet
import kotlinx.android.synthetic.main.activity_main.ivEmpty
import kotlinx.android.synthetic.main.activity_main.progressBar

class MainActivity : AppCompatActivity(), Communicator {
    lateinit var cryptoViewModel: CryptoViewModel
    lateinit var cryptoNameAdapter: CryptoNameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        setObserver()
        onClick()
        initApi()
    }

    private fun onClick() {
        btnInternet.setOnClickListener{
           if(isInternetAvailable(this)){
               initApi()
               setObserver()
           }else{
               showSnackBar(it)
           }

        }

    }

    private fun initViewModel() {
        cryptoViewModel = ViewModelProvider(this).get(CryptoViewModel::class.java)

    }

    private fun initApi() {
        if (isInternetAvailable(this)) {
            cryptoViewModel.fetchCryptoData()
            ivInternet.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
            ivEmpty.visibility = View.VISIBLE
            btnInternet.visibility=View.GONE


        } else {
            ivInternet.visibility = View.VISIBLE
            ivEmpty.visibility = View.GONE
            progressBar.visibility = View.GONE
            btnInternet.visibility=View.VISIBLE

        }
    }




    private fun setObserver() {
        if(isInternetAvailable(this)){
            cryptoViewModel.successData().observe(this, Observer {
                cryptoNameAdapter = CryptoNameAdapter(this, it, this)
                rvCrypto.adapter = cryptoNameAdapter
                rvCrypto.layoutManager = LinearLayoutManager(this)
                progressBar.visibility = View.GONE
                ivEmpty.visibility = View.GONE
            })
        }

    }

    override fun onPassingID(id: String) {
        var intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }



}