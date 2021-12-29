package com.example.cryptoinfo.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoinfo.R
import com.example.cryptoinfo.adapters.CryptoNameAdapter
import com.example.cryptoinfo.utils.Communicator
import com.example.cryptoinfo.utils.Constants.isInternetAvailable
import com.example.cryptoinfo.utils.Constants.showSnackBar
import com.example.cryptoinfo.view.activities.DetailActivity
import com.example.cryptoinfo.viewmodel.CryptoViewModel
import kotlinx.android.synthetic.main.fragment_currency.*

class CurrencyFragment : Fragment(), Communicator {
    lateinit var cryptoViewModel: CryptoViewModel
    lateinit var cryptoNameAdapter: CryptoNameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        setObserver()
        onClick()
        initApi()
    }

    private fun onClick() {
        btnInternet.setOnClickListener{
           if(isInternetAvailable(requireContext())){
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
        if (isInternetAvailable(requireContext())) {
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
        if(isInternetAvailable(requireContext())){
            cryptoViewModel.successData().observe(requireActivity(), Observer {
                cryptoNameAdapter = CryptoNameAdapter(requireContext(), it, this)
                rvCrypto.adapter = cryptoNameAdapter
                rvCrypto.layoutManager = LinearLayoutManager(requireContext())
                progressBar.visibility = View.GONE
                ivEmpty.visibility = View.GONE
            })
        }

    }

    override fun onPassingID(id: String) {
        var intent = Intent(requireContext(), DetailActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }



}