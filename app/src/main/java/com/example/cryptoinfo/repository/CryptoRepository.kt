package com.example.cryptoinfo.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.cryptoinfo.model.coinpapernika.cryptodetails.CryptoDeatils
import com.example.cryptoinfo.model.cryptomarketcap.cryptomarketdetails.CryptoMarketDetails
import com.example.cryptoinfo.model.cryptomarketcap.cryptomarketdetails.Data
import com.example.cryptoinfo.model.coinpapernika.cryptonames.CryptoName
import com.example.cryptoinfo.utils.Constants
import com.example.cryptoinfo.utils.api.CryptoInstance
import com.example.cryptoinfo.model.data.allnews.Article
import com.example.newssy.data.topheadlines.TopHeadlines
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await

class CryptoRepository(application: Application) {
    var mSuccessData = MutableLiveData<CryptoName>()
    var mSuccessTagsData = MutableLiveData<CryptoDeatils>()
    var mSuccessMembersData = MutableLiveData<CryptoDeatils>()
    var mSuccessCryptoMarketData = MutableLiveData<CryptoMarketDetails>()
    var mSuccessPriceData = MutableLiveData<Data>()
    var mSuccessPriceByIDData = MutableLiveData<Data>()
    var mSuccessNewsData = MutableLiveData<Article>()
    var mFailureData = MutableLiveData<String>()
    var mSuccessHeadLines = MutableLiveData<TopHeadlines>()


    fun fetchCryptoNamesData() {
        CoroutineScope(Dispatchers.IO).launch {
            val crypto =
                CryptoInstance.RetrofitInstanceCoinpaprika.cryptoService.getCoinsData().await()
            mSuccessData.postValue(crypto)

        }
    }

    fun fetchTagsData(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val tagsData =
                CryptoInstance.RetrofitInstanceCoinpaprika.cryptoService.getCoinsDetailsData(id)
                    .await()
            mSuccessTagsData.postValue(tagsData)
        }
    }

    fun fetchMembersData(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val membersData =
                CryptoInstance.RetrofitInstanceCoinpaprika.cryptoService.getCoinsDetailsData(id)
                    .await()
            mSuccessMembersData.postValue(membersData)
        }
    }

    fun getMarketData() {
        CoroutineScope(Dispatchers.IO).launch {
            val marketData =
                CryptoInstance.RetrofitInstanceCoinMarketCap.cryptoService.getCryptoMarketDetails(
                    Constants.CRYPTO_API_KEY
                ).await()
            mSuccessCryptoMarketData.postValue(marketData)
        }
    }

    //    fun getCryptoPrice() {
//        CoroutineScope(Dispatchers.IO).launch {
//            val price = RetrofitInstance2.cryptoService.getPrice(API_KEY).await()
//            mSuccessPriceData.postValue(price)
//
//        }
//
//    }
//
//    fun fetchPriceById(id: Int) {
//        CoroutineScope(Dispatchers.IO).launch {
//            val price = RetrofitInstance2.cryptoService.getPriceById(API_KEY, id).await()
//            mSuccessPriceByIDdata.postValue(price)
//
//        }
    fun fetchNewsData(userInput: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val news = CryptoInstance.RetrofitNewsInstance.cryptoService.getNews(
                userInput,
                Constants.NEWS_API_KEY
            ).await()
            mSuccessNewsData.postValue(news)

        }
    }

    fun fetchTopHeadlinesData() {
        CoroutineScope(Dispatchers.IO).launch {
            val topHeadlines =
                CryptoInstance.RetrofitNewsInstance.cryptoService.getTrendingNews(
                    "bitcoin",
                    Constants.NEWS_API_KEY
                ).await()
            mSuccessHeadLines.postValue(topHeadlines)
        }
    }
}

