package com.example.cryptoinfo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoinfo.R
import com.example.cryptoinfo.adapters.MoreInfoAdapter
import com.example.cryptoinfo.utils.Constants
import com.example.cryptoinfo.viewmodel.CryptoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_more_info.*
import kotlinx.android.synthetic.main.activity_more_info.ivEmpty
import kotlinx.android.synthetic.main.activity_more_info.progressBar

class MoreInfoActivity : AppCompatActivity() {
    lateinit var moreInfoAdapter: MoreInfoAdapter
    lateinit var cryptoViewModel: CryptoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)
        initViewModel()
        initApi()
        setObserver()

    }
    private fun initViewModel() {
        cryptoViewModel=ViewModelProvider(this).get(CryptoViewModel::class.java)

    }
    private fun initApi() {
        cryptoViewModel.fetchCryptoMarketData()

    }

    private fun setObserver() {
        if(Constants.isInternetAvailable(this)){
            progressBar.visibility = View.VISIBLE
            ivEmpty.visibility = View.VISIBLE
        cryptoViewModel.successMarketData().observe(this, Observer {
            Log.d("response", "setObserver: ${it.data}")
            moreInfoAdapter= MoreInfoAdapter(it.data, this)
            rvInfo.layoutManager=LinearLayoutManager(this)
            rvInfo.adapter=moreInfoAdapter
            progressBar.visibility = View.GONE
            ivEmpty.visibility = View.GONE
        })
    }
    }


}