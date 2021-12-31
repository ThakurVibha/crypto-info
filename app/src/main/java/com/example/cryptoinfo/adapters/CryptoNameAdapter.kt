package com.example.cryptoinfo.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoinfo.R
import com.example.cryptoinfo.model.coinpapernika.cryptonames.CryptoNameItem
import com.example.cryptoinfo.utils.communicators.onPassingID
import kotlinx.android.synthetic.main.cypto_item_layout.view.*

class CryptoNameAdapter(var context: Context, var cryptoNameList: List<CryptoNameItem>, var communicator: onPassingID) :
    RecyclerView.Adapter<CryptoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.cypto_item_layout, parent, false)
        return CryptoViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        var cryptoNameList: CryptoNameItem = cryptoNameList[position]
        holder.itemView.tvCurrencyName.text = cryptoNameList.name
        holder.itemView.tvRank.text = cryptoNameList.rank.toString()
        holder.itemView.tvSymbol.text = cryptoNameList.symbol

        holder.itemView.setOnClickListener {
                communicator.onPassingID(cryptoNameList.id)

        }


    }

    override fun getItemCount(): Int {
        return cryptoNameList.size
    }
}

class CryptoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}