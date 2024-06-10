package com.example.news_data.repository

import com.example.news_data.mapper.toDomainArticle
import com.example.news_data.network.NewsListApiService
import com.example.news_domain.model.Article
import com.example.news_domain.repository.NewsListRepository

class NewsRepoImpl(private val newsListApiService: NewsListApiService) : NewsListRepository {
    override suspend fun getNewsArticles(): List<Article> {
        return newsListApiService.getArticles().articles.map { it.toDomainArticle() }
    }
}