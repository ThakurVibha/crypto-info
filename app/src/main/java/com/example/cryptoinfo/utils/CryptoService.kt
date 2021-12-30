package com.example.cryptoinfo.utils

import com.example.cryptoinfo.BuildConfig
import com.example.cryptoinfo.data.cryptodetails.CryptoDeatils
import com.example.cryptoinfo.data.cryptomarketdetails.CryptoMarketDetails
import com.example.cryptoinfo.data.cryptomarketdetails.Data
import com.example.cryptoinfo.data.cryptonames.CryptoName
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


var BASE_URL = "https://api.coinpaprika.com/v1/"
var BASE_URL_NEW = "https://pro-api.coinmarketcap.com/v1/"
var API_KEY = "a33fbb95-9591-46b5-899d-cd6815e66d9a"

interface CryptoService {

    @GET("coins/")
    fun getCoinsData(): Call<CryptoName>

    @GET("coins/{id}")
    fun getCoinsDetailsData(@Path("id") id: String): Call<CryptoDeatils>

    @GET("cryptocurrency/listings/latest")
    fun getCryptoMarketDetails(@Query("CMC_PRO_API_KEY") key: String): Call<CryptoMarketDetails>

    @GET("cryptocurrency/listings/latest")
    fun getPrice(@Query("CMC_PRO_API_KEY") key: String): Call<Data>

    @GET("cryptocurrency/info")
    fun getPriceById(@Query("CMC_PRO_API_KEY") key: String, @Path("id")id: String): Call<Data>

}

object RetrofitInstance {
    var cryptoService: CryptoService

    init {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        //interface for implementation
        cryptoService = retrofit.create(CryptoService::class.java)
    }
}

object RetrofitInstance2 {
    var cryptoService: CryptoService

    //create okhttp client
    init {

        var okHttpClient = OkHttpClient.Builder()

        //create interceptor
        var httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClient.addInterceptor(httpLoggingInterceptor)

        }


        var retrofit = Retrofit.Builder().baseUrl(BASE_URL_NEW)
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient.build()).build()
        //interface for implementation
        cryptoService = retrofit.create(CryptoService::class.java)

    }
}
