package com.example.cryptoinfo.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cryptoinfo.R
import com.example.cryptoinfo.adapters.MoreInfoAdapter
import com.example.cryptoinfo.data.cryptomarketdetails.Data
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
        spCountries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                Toast.makeText(
                    requireContext(),
                    parent!!.getItemAtPosition(position).toString(),
                    Toast.LENGTH_SHORT
                ).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

        }
    }

    private fun initAPI() {
        cryptoViewModel.fetchCryptoMarketData()

    }

    private fun initViewModel() {
        cryptoViewModel = ViewModelProvider(this).get(CryptoViewModel::class.java)
    }

    private fun setObserver() {
        cryptoViewModel.successMarketData().observe(requireActivity(), Observer {
            adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, it.data)
            spCurrencies.adapter = adapter
            //TODO add spinners and complete functionality of getting list of items

        })

    }


}