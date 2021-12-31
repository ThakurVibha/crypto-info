package com.example.cryptoinfo.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import com.example.cryptoinfo.view.fragments.CurrencyFragment
import com.example.cryptoinfo.viewmodel.CryptoViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class DetailActivity : AppCompatActivity() {

    lateinit var cryptoViewModel: CryptoViewModel
    lateinit var tagsAdapter: TagsAdapter
    private lateinit var membersAdapter: MembersAdapter
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
        ivBack.setOnClickListener {
            startActivity(Intent(this, CurrencyFragment::class.java))
        }
        ivMoreInfo.setOnClickListener {
            startActivity(Intent(this, MoreInfoActivity::class.java))
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

                if (it.team.isEmpty()) {
                    tvMember.visibility = View.GONE
                }
                if (it.description.isEmpty()) {
                    tvDescription.visibility = View.GONE
                    tvAbout.visibility = View.GONE
                    view.visibility = View.GONE

                }

            })
        }


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