package com.example.news_domain.repository

import com.example.news_domain.model.Article

class FakeNewsListRepositoryError : NewsListRepository {

    override suspend fun getNewsArticles(): List<Article> {
        throw Exception("Something went wrong")
    }

}