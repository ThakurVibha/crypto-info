package com.example.cryptoinfo.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.distinctUntilChanged
import com.example.cryptoinfo.data.cryptodetails.CryptoDeatils
import com.example.cryptoinfo.data.cryptomarketdetails.CryptoMarketDetails
import com.example.cryptoinfo.data.cryptonames.CryptoName
import com.example.cryptoinfo.utils.RetrofitInstance
import com.example.cryptoinfo.utils.RetrofitInstance2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await

class CryptoRepository(application: Application) {
    var mSuccessData = MutableLiveData<CryptoName>()
    var mSuccessTagsData = MutableLiveData<CryptoDeatils>()
    var mSuccessMembersData = MutableLiveData<CryptoDeatils>()
    var mSuccessCryptoMarketData = MutableLiveData<CryptoMarketDetails>()


    fun fetchCryptoNamesData() {
        try{
            CoroutineScope(Dispatchers.IO).launch {
                val crypto = RetrofitInstance.cryptoService.getCoinsData().await()
                mSuccessData.postValue(crypto)

            }
        }catch (e:Exception){
            Log.e("TAG", e.localizedMessage)
        }

    }

    fun fetchTagsData(id: String) {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val tagsData = RetrofitInstance.cryptoService.getCoinsDetailsData(id).await()
                mSuccessTagsData.postValue(tagsData)
            }
        }catch (e:Exception){
            Log.e("TAG", e.localizedMessage)
        }

    }

    fun fetchMembersData(id: String) {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val membersData = RetrofitInstance.cryptoService.getCoinsDetailsData(id).await()
                mSuccessMembersData.postValue(membersData)
            }

        }catch (e:Exception){
            Log.e("TAG", e.localizedMessage)

        }

    }
//
//    fun getMarketData() {
//        CoroutineScope(Dispatchers.IO).launch {
//            val marketData = RetrofitInstance2.cryptoService.getCryptoMarketDetails().await()
//            mSuccessCryptoMarketData.postValue(marketData)
//        }
//    }


}