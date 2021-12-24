package com.example.cryptoinfo.utils

import android.app.Service
import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.View
import com.google.android.material.snackbar.Snackbar


var connectivity: ConnectivityManager? = null
var info: NetworkInfo? = null

object Constants {

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