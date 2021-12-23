package com.example.cryptoinfo.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.cryptoinfo.data.cryptodetails.CryptoDeatils
import com.example.cryptoinfo.data.cryptomarketdetails.CryptoMarketDetails
import com.example.cryptoinfo.data.cryptonames.CryptoName
import com.example.cryptoinfo.utils.Communicator
import com.example.cryptoinfo.utils.RetrofitInstance
import com.example.cryptoinfo.utils.RetrofitInstance2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await

class CryptoRepository(application: Application) {
    var mSuccessData = MutableLiveData<CryptoName>()
    lateinit var communicator: Communicator
    var mSuccessTagsData=MutableLiveData<CryptoDeatils>()
    var mSuccessMembersData=MutableLiveData<CryptoDeatils>()
    var mSuccessCryptoMarketData=MutableLiveData<CryptoMarketDetails>()


    fun fetchCryptoNamesData() {
        CoroutineScope(Dispatchers.IO).launch {
            val crypto = RetrofitInstance.cryptoService.getCoinsData().await()
            mSuccessData.postValue(crypto)
        }
    }

    fun fetchTagsData(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val tagsData=RetrofitInstance.cryptoService.getCoinsDetailsData(id).await()
            mSuccessTagsData.postValue(tagsData)
        }
    }

    fun fetchMembersData(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val membersData=RetrofitInstance.cryptoService.getCoinsDetailsData(id).await()
            mSuccessMembersData.postValue(membersData)
        }
    }

    fun getMarketData() {
        CoroutineScope(Dispatchers.IO).launch {
            val marketData=RetrofitInstance2.cryptoService.getCryptoMarketDetails().await()
            mSuccessCryptoMarketData.postValue(marketData)
        }
    }


}