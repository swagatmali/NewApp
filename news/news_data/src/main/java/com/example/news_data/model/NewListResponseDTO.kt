package com.example.news_data.model

data class NewListResponseDTO(
    val articles: List<ArticleDTO>,
    val status: String,
    val totalResults: Int
)