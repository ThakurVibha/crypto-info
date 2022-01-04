package com.example.cryptoinfo.utils.api

import com.example.cryptoinfo.model.coinpapernika.cryptodetails.CryptoDeatils
import com.example.cryptoinfo.model.cryptomarketcap.cryptomarketdetails.CryptoMarketDetails
import com.example.cryptoinfo.model.cryptomarketcap.cryptomarketdetails.Data
import com.example.cryptoinfo.model.coinpapernika.cryptonames.CryptoName
import com.example.cryptoinfo.model.cryptomarketcap.dialogurls.Urls
import com.example.cryptoinfo.model.data.allnews.Article
import com.example.newssy.data.topheadlines.TopHeadlines

import retrofit2.Call
import retrofit2.http.*



interface CryptoService {

    //getting currency name and basic info(coinpaprika)
    @GET("coins/")
    fun getCoinsData(): Call<CryptoName>

    //getting currency details by ID
    @GET("coins/{id}")
    fun getCoinsDetailsData(@Path("id") id: String): Call<CryptoDeatils>

    //getting currency data using(coinmarketcap api)
    @GET("cryptocurrency/listings/latest")
    fun getCryptoMarketDetails(@Query("CMC_PRO_API_KEY") key: String): Call<CryptoMarketDetails>

    //getting USD price
    @GET("cryptocurrency/listings/latest")
    fun getPrice(@Query("CMC_PRO_API_KEY") key: String): Call<Data>

    @GET("cryptocurrency/info")
    fun getPriceById(@Query("CMC_PRO_API_KEY") key: String, @Query("id") id: Int): Call<Data>

    //getting url data
    @GET("cryptocurrency/info")
    fun getUrlData(@Query("CMC_PRO_API_KEY") key: String, @Query("id") id: Int): Call<Urls>

    @GET("v2/everything")
    fun getNews(@Query("q") query: String, @Query("apiKey") api_key: String): Call<Article>

    @GET("v2//everything")
    fun getTrendingNews(@Query ("q") title: String,@Query ("apiKey") api_key: String):Call<TopHeadlines>


}
