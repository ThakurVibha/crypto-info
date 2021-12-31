package com.example.cryptoinfo.view.activities

import android.content.Intent
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
import com.example.cryptoinfo.utils.communicators.Onclick
import com.example.cryptoinfo.viewmodel.CryptoViewModel
import kotlinx.android.synthetic.main.activity_more_info.*
import kotlinx.android.synthetic.main.activity_more_info.ivEmpty
import kotlinx.android.synthetic.main.activity_more_info.progressBar
import kotlinx.android.synthetic.main.info_dialog_layout.*

class MoreInfoActivity : AppCompatActivity(), Onclick {
    lateinit var moreInfoAdapter: MoreInfoAdapter
    lateinit var cryptoViewModel: CryptoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)
        initViewModel()
        initApi()
        onClickItem()
        setObserver()

    }

    private fun onClickItem() {
        ivCancel.setOnClickListener {
            infoDialog.visibility=View.GONE
            clMoreInfo.visibility=View.VISIBLE
        }

        TODO("make an api callto get url data")
        ivWebsite.setOnClickListener {
            var openWebsiteIntent= Intent(Intent.ACTION_VIEW, )
        }

    }


    private fun initViewModel() {
        cryptoViewModel = ViewModelProvider(this).get(CryptoViewModel::class.java)

    }

    private fun initApi() {
        cryptoViewModel.fetchCryptoMarketData()

    }



    private fun setObserver() {
        if (Constants.isInternetAvailable(this)) {
            progressBar.visibility = View.VISIBLE
            ivEmpty.visibility = View.VISIBLE
            cryptoViewModel.successMarketData().observe(this, Observer {
                Log.d("response", "setObserver: ${it.data}")
                moreInfoAdapter = MoreInfoAdapter(it.data, this, this)
                rvInfo.layoutManager = LinearLayoutManager(this)
                rvInfo.adapter = moreInfoAdapter
                progressBar.visibility = View.GONE
                ivEmpty.visibility = View.GONE
            })
        }
    }

    override fun onClick() {
        infoDialog.visibility=View.VISIBLE

    }


}