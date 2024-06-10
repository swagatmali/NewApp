package com.example.news_data.model

import com.example.news_domain.model.Article

data class NewListResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)