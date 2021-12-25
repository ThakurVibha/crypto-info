package com.example.cryptoinfo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoinfo.R
import com.example.cryptoinfo.data.cryptomarketdetails.Data
import kotlinx.android.synthetic.main.moreinfo_layout_item.view.*

class MoreInfoAdapter(var moreInfoList: List<Data>, var context: Context) :
    RecyclerView.Adapter<MoreInfoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreInfoViewHolder {
        var view =
            LayoutInflater.from(context).inflate(R.layout.moreinfo_layout_item, parent, false)
        return MoreInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoreInfoViewHolder, position: Int) {
        var dataList: Data = moreInfoList[position]
        holder.itemView.tvSlug.text=dataList.slug
        holder.itemView.tvAddedDate.text=dataList.date_added
        holder.itemView.tvMaxSupply.text= dataList.max_supply.toString()
        holder.itemView.tvCirculatingSupply.text=dataList.circulating_supply.toString()
        holder.itemView.tvMarketPairs.text= dataList.num_market_pairs.toString()
        holder.itemView.tvPrice.text= dataList.quote.USD.price.toString()
        holder.itemView.tvCurrencyName.text= dataList.name
        holder.itemView.tvRank.text= dataList.cmc_rank.toString()
        holder.itemView.tvSymbol.text= dataList.symbol


    }

    override fun getItemCount(): Int {
        return moreInfoList.size
    }
}

class MoreInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)