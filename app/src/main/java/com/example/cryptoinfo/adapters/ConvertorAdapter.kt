package com.example.cryptoinfo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoinfo.R
import com.example.cryptoinfo.model.coinpapernika.converteddata.ConvertModel

class ConvertorAdapter(var context: Context, var convertedList:List<ConvertModel>):RecyclerView.Adapter<ConvertorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ConvertorViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.convertor_item_layout, parent, false)
        return ConvertorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConvertorViewHolder, position: Int) {
        var list:ConvertModel=convertedList[position]
//        holder.itemView.tvBtc.text= list.BTC


    }

    override fun getItemCount(): Int {
        return convertedList.size
    }

}
class ConvertorViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)