package com.example.news_domain.model


data class Article(
    val title: String,
    val publishedAt: String,
    val urlToImage: String,
    val author: String,
    val description: String
)