package com.example.cryptoinfo.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoinfo.R
import com.example.cryptoinfo.adapters.MoreInfoAdapter
import com.example.cryptoinfo.model.cryptomarketcap.cryptomarketdetails.Data
import com.example.cryptoinfo.viewmodel.CryptoViewModel
import kotlinx.android.synthetic.main.fragment_convertor.*


class CalculatorFragment : Fragment() {
    lateinit var moreInfoAdapter: MoreInfoAdapter
    lateinit var cryptoViewModel: CryptoViewModel
    private lateinit var adapter: ArrayAdapter<Data>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_convertor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initAPI()
        setObserver()
        onSpinnerItemSelection()

    }

    private fun onSpinnerItemSelection() {

        spCurrencies.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

//                cryptoViewModel.successPriceData().observe(requireActivity(), Observer {
//                    Log.e("data", "onItemSelected: " + it.id)
//                    cryptoViewModel.fetchPriceByID(it.id)
//
//                })

//                cryptoViewModel.successPriceByIDdata().observe(requireActivity(), Observer {
//                    Log.e(TAG, "onItemSelected: ", )
//                })



            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }


        }
    }

    private fun initAPI() {
        cryptoViewModel.fetchCryptoMarketData()
//        cryptoViewModel.fetchPrice()


    }

    private fun initViewModel() {
        cryptoViewModel = ViewModelProvider(this).get(CryptoViewModel::class.java)
    }

    private fun setObserver() {
        cryptoViewModel.successMarketData().observe(requireActivity(), Observer {
            adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, it.data)
            spCurrencies.adapter = adapter

        })

    }


}