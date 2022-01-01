package com.example.cryptoinfo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptoinfo.R
import kotlinx.android.synthetic.main.onboardingitem_layout.view.*


class OnBoardingAdapter : RecyclerView.Adapter<PagerVH>() {

    //array of colors to change the background color of screen
    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
        PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.onboardingitem_layout, parent, false))

    //get the size of color array
    override fun getItemCount(): Int = Int.MAX_VALUE

    //binding the screen with view
    override fun onBindViewHolder(holder: PagerVH, position: Int) = holder.itemView.run {
        if(position == 0){
            tvInfo.text = "Are you one of\n those who knows\n nothing about\n Cryptocurrency?"
            ivImage.setImageResource(R.drawable.onboardingimage1)
        }
        if(position == 1) {
            tvInfo.text = "Get all data \n in realtime and \n explore authentic \n web references"
            ivImage.setImageResource(R.drawable.onboardingimage2)
        }
        if(position == 2) {
            tvInfo.text = "Calculate your\n favourite Crypto\n price in USD"
            ivImage.setImageResource(R.drawable.calculator)

        }

    }
}

class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView)