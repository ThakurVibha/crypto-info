package com.example.cryptoinfo.model.data.allnews

import com.example.newssy.data.allnews.News

data class Article(
    val articles: ArrayList<News>,
    val status: String,
    val totalResults: Int
)