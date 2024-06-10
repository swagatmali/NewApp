package com.example.news_domain.repository

import com.example.news_domain.model.Article

class FakeNewsListRepository : NewsListRepository {

    private val article1 = Article(
        author = "Author1",
        title = "Title1",
        description = "Description1",
        urlToImage = "UrlToImage1",
        publishedAt = "PublishedAt1"
    )
    private val article2 = Article(
        author = "Author2",
        title = "Title2",
        description = "Description2",
        urlToImage = "UrlToImage2",
        publishedAt = "PublishedAt2"
    )
    private val articles = listOf(article1, article2)

    override suspend fun getNewsArticles(): List<Article> {
        return articles
    }

}