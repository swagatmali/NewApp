package com.example.news_domain.repository

import com.example.news_domain.model.Article

interface NewsListRepository {

    suspend fun getNewsArticles(): List<Article>
}