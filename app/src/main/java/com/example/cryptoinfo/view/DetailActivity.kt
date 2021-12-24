package com.example.cryptoinfo.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoinfo.R
import com.example.cryptoinfo.adapters.MembersAdapter
import com.example.cryptoinfo.adapters.TagsAdapter
import com.example.cryptoinfo.utils.Constants
import com.example.cryptoinfo.utils.Constants.showSnackBar
import com.example.cryptoinfo.viewmodel.CryptoViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var cryptoViewModel: CryptoViewModel
    lateinit var tagsAdapter: TagsAdapter
    lateinit var membersAdapter: MembersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViewModel()
        initApi()
        setObserver()
        onClick()


    }

    private fun onClick() {
        btnInternet.setOnClickListener {
            if (Constants.isInternetAvailable(this)) {
                initApi()
                setObserver()
            } else {
                showSnackBar(view)
            }

        }
    }

    private fun setObserver() {
        if (Constants.isInternetAvailable(this)) {
            cryptoViewModel.successTagsData().observe(this, Observer {
                tagsAdapter = TagsAdapter(this, it.tags)
                rvTags.adapter = tagsAdapter
                rvTags.layoutManager = GridLayoutManager(this, 2)
                membersAdapter = MembersAdapter(this, it.team)

                rvMembers.adapter = membersAdapter
                rvMembers.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                tvDescription.text = it.description
                tvCurrencyName.text = it.name
                tvRank.text = it.rank.toString()
                tvSymbol.text = it.symbol
                tvMember.visibility = View.VISIBLE
                tvTags.visibility = View.VISIBLE
                tvAbout.visibility = View.VISIBLE
                view.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
                tvDescription.visibility = View.VISIBLE
                ivEmpty.visibility = View.GONE
                clCard.visibility = View.VISIBLE


            })
        }

        cryptoViewModel.successMarketData().observe(this, Observer {
            Log.e("tags", "setObserver: $it")
        })
    }

    private fun initApi() {
        if (Constants.isInternetAvailable(this)) {
            btnInternet.visibility = View.GONE
            ivNoInternet.visibility = View.GONE
            var id = intent.getStringExtra("id")!!
            cryptoViewModel.fetchTagsData(id)
            cryptoViewModel.fetchMembersData(id)
            progressBar.visibility = View.VISIBLE
            ivEmpty.visibility = View.VISIBLE
            cryptoViewModel.fetchCryptoMarketData()
        } else {
            btnInternet.visibility = View.VISIBLE
            ivNoInternet.visibility = View.VISIBLE
            ivEmpty.visibility = View.GONE
            progressBar.visibility = View.GONE
            clCard.visibility = View.GONE


        }


    }

    private fun initViewModel() {
        cryptoViewModel = ViewModelProvider(this).get(CryptoViewModel::class.java)
    }


}