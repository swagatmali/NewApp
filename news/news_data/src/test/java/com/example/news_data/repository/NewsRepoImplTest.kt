package com.example.news_data.repository

import com.example.news_data.model.ArticleDTO
import com.example.news_data.model.NewListResponseDTO
import com.example.news_data.model.SourceDTO
import com.example.news_data.network.NewsListApiService
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.junit.Assert.*
import org.mockito.MockitoAnnotations


class NewsRepoImplTest {

    private lateinit var newsRepoImpl: NewsRepoImpl

    @Mock
    private lateinit var newsListApiService: NewsListApiService

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        newsRepoImpl = NewsRepoImpl(newsListApiService)
    }

    @Test
    fun `test newsRepoImpl_getArticles_Success`(): Unit = runBlocking {
        val article1 = ArticleDTO(
            author = "Author1",
            title = "Title1",
            description = "Description1",
            urlToImage = "UrlToImage1",
            publishedAt = "PublishedAt1",
            content = "Content1",
            source = SourceDTO(
                id = "SourceId1",
                name = "SourceName1"
            ),
            url = "Url1",
        )
        val news = NewListResponseDTO(articles = listOf(article1), status = "ok", totalResults = 1)
        Mockito.`when`(newsListApiService.getArticles()).thenReturn(news)

        assertEquals(news, newsRepoImpl.getNewsArticles())
    }
}