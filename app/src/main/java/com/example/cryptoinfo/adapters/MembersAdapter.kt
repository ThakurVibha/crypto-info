package com.example.cryptoinfo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoinfo.R
import com.example.cryptoinfo.data.cryptodetails.Team
import kotlinx.android.synthetic.main.members_item_layout.view.*

class MembersAdapter(var context: Context, var membersList: List<Team>) :
    RecyclerView.Adapter<MembersViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MembersViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.members_item_layout, parent, false)
        return MembersViewHolder(view)

    }

    override fun onBindViewHolder(holder: MembersViewHolder, position: Int) {
        var team:Team=membersList[position]
        holder.itemView.tvMemberName.text=team.name
        holder.itemView.tvPosition.text=team.position

    }

    override fun getItemCount(): Int {
        return membersList.size
    }

}

class MembersViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)