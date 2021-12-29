package com.example.cryptoinfo.data.cryptomarketdetails

data class Data(
    val circulating_supply: Float,
    val cmc_rank: Int,
    val date_added: String,
    val id: Int,
    val last_updated: String,
    val max_supply: Float,
    val name: String,
    val num_market_pairs: Float,
    val platform: Any,
    val quote: Quote,
    val slug: String,
    val symbol: String,
    val tags: List<String>,
    val total_supply: Float
){
    override fun toString(): String {
        return name
    }
}

