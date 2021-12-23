package com.example.cryptoinfo.utils

import com.example.cryptoinfo.data.cryptodetails.CryptoDeatils
import com.example.cryptoinfo.data.cryptomarketdetails.CryptoMarketDetails
import com.example.cryptoinfo.data.cryptonames.CryptoName
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


var BASE_URL = "https://api.coinpaprika.com/v1/"
var BASE_URL_NEW="https://pro-api.coinmarketcap.com/v1/"

interface CryptoService {

    @GET("coins/")
    fun getCoinsData(): Call<CryptoName>

    @GET("coins/{id}")
    fun getCoinsDetailsData(@Path("id")id:String): Call<CryptoDeatils>

    @GET("cryptocurrency/listings/latest")
    @Headers("X-CMC_PRO_API_KEY: a33fbb95-9591-46b5-899d-cd6815e66d9a")
    fun getCryptoMarketDetails():Call<CryptoMarketDetails>

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

    var cryptoService:CryptoService
    init {
        val retrofit=Retrofit.Builder().baseUrl(BASE_URL_NEW).addConverterFactory(GsonConverterFactory.create()).build()
        //interface for implementation
        cryptoService=retrofit.create(CryptoService::class.java)
    }
}

