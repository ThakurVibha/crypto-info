package com.example.cryptoinfo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoinfo.R
import com.example.cryptoinfo.data.cryptodetails.Tag
import kotlinx.android.synthetic.main.tag_item_lyout.view.*

class TagsAdapter(var context: Context, var cryptoDetailsList: List<Tag>) :
    RecyclerView.Adapter<TagsAdapter.CryptoDetailsViewHolder>() {

    class CryptoDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoDetailsViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.tag_item_lyout, parent, false)
        return CryptoDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CryptoDetailsViewHolder, position: Int) {
        var tagList:Tag=cryptoDetailsList[position]
        holder.itemView.tvTag.text=tagList.name
    }

    override fun getItemCount(): Int {
        return cryptoDetailsList.size
    }

}