package com.example.cryptoinfo.utils.api

import com.example.cryptoinfo.BuildConfig
import com.example.cryptoinfo.utils.Constants.BASE_URL_COINMARKETCAP
import com.example.cryptoinfo.utils.Constants.BASE_URL_COINPAPRIKA
import com.example.cryptoinfo.utils.Constants.BASE_URL_NEWS
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptoInstance {

    //instance for coinpaprika api
    object RetrofitInstanceCoinpaprika {
        var cryptoService: CryptoService

        init {
            val retrofit =
                Retrofit.Builder().baseUrl(BASE_URL_COINPAPRIKA).addConverterFactory(
                    GsonConverterFactory.create())
                    .build()
            //interface for implementation
            cryptoService = retrofit.create(CryptoService::class.java)
        }
    }

    //instance for coinmarketcap api
    object RetrofitInstanceCoinMarketCap {
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


            var retrofit = Retrofit.Builder().baseUrl(BASE_URL_COINMARKETCAP)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient.build()).build()
            //interface for implementation
            cryptoService = retrofit.create(CryptoService::class.java)

        }
}

    //instance for news api
    object RetrofitNewsInstance {
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


            var retrofit = Retrofit.Builder().baseUrl(BASE_URL_NEWS)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient.build()).build()
            //interface for implementation
            cryptoService = retrofit.create(CryptoService::class.java)

        }
    }

}