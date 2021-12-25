package com.example.cryptoinfo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cryptoinfo.data.cryptodetails.CryptoDeatils
import com.example.cryptoinfo.data.cryptomarketdetails.CryptoMarketDetails
import com.example.cryptoinfo.data.cryptonames.CryptoName
import com.example.cryptoinfo.repository.CryptoRepository

class CryptoViewModel(application: Application) : AndroidViewModel(application) {
    var cryptoRepository = CryptoRepository(application)

    fun fetchCryptoData() {
        cryptoRepository.fetchCryptoNamesData()
    }

    fun successData(): MutableLiveData<CryptoName> {
        return cryptoRepository.mSuccessData
    }


    fun successTagsData(): MutableLiveData<CryptoDeatils> {
        return cryptoRepository.mSuccessTagsData
    }

    fun successMarketData(): MutableLiveData<CryptoMarketDetails> {
        return cryptoRepository.mSuccessCryptoMarketData
    }

    fun fetchMembersData(id: String) {
        cryptoRepository.fetchMembersData(id)

    }

    fun fetchTagsData(id: String) {
        cryptoRepository.fetchTagsData(id)
    }

    fun fetchCryptoMarketData() {
        cryptoRepository.getMarketData()
    }


}