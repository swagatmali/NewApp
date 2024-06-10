package com.example.news_data.mapper

import com.example.news_data.model.ArticleDTO
import com.example.news_domain.model.Article

fun ArticleDTO.toDomainArticle(): Article {
    return Article(
        author = this.author?:"",
        description = this.description?:"",
        publishedAt = this.publishedAt?:"",
        title = this.title?:"",
        urlToImage = this.urlToImage?:""
    )
}