package com.example.cryptoinfo.utils

import android.app.Service
import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import com.google.android.material.snackbar.Snackbar



object Constants {
    var CRYPTO_API_KEY="e8fff1ed-f894-492a-9ff5-dfbb35814798"
    var connectivity: ConnectivityManager? = null
    var info: NetworkInfo? = null
    var BASE_URL_COINPAPRIKA = "https://api.coinpaprika.com/v1/"
    var BASE_URL_COINMARKETCAP = "https://pro-api.coinmarketcap.com/v1/"
    const val BASE_URL_NEWS = "https://newsapi.org/"
    const val NEWS_API_KEY = "b4a158ac361840a3ad16696458084fc1"

    fun showSnackBar(view: View) {
        val snackbar = Snackbar.make(
            view, "Turn on your data and try again!",
            Snackbar.LENGTH_LONG
        ).setAction("Action", null)
        snackbar.setActionTextColor(Color.BLUE)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor(Color.BLACK)
        snackbar.show()
    }


    fun isInternetAvailable(context: Context): Boolean {
        connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE)
                as ConnectivityManager
        if (connectivity != null) {
            info = connectivity!!.activeNetworkInfo

            if (info != null) {
                if (info!!.state == NetworkInfo.State.CONNECTED) {
                }
                return true

            } else {
            }
        }
        return false
    }





}