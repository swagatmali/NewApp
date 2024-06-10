package com.example.news_domain.use_case

import com.example.common_util.Resource
import com.example.news_domain.repository.FakeNewsListRepository
import com.example.news_domain.repository.FakeNewsListRepositoryError
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class GetNewsArticlesUseCaseTest {

    private lateinit var getNewsArticlesUseCase: GetNewsArticlesUseCase
    private lateinit var fakeNewsListRepository: FakeNewsListRepository

    private lateinit var faeNewsListRepositoryError: FakeNewsListRepositoryError

    @Before
    fun setUp() {
        fakeNewsListRepository = FakeNewsListRepository()
        faeNewsListRepositoryError = FakeNewsListRepositoryError()
        getNewsArticlesUseCase = GetNewsArticlesUseCase(fakeNewsListRepository)
    }

    @Test
    fun `test newsArticlesUseCase_getNewsArticles_Success`(): Unit = runBlocking {
        val articles = getNewsArticlesUseCase.invoke()
        articles.collect {
            if (it is Resource.Success) {
                assertEquals(2, it.data.size)
            }
        }
    }

    @Test
    fun `test newsArticlesUseCase_getNewsArticles_Failure`(): Unit = runBlocking {
        val expectedError = "Something went wrong"
        val getNewsArticlesUseCaseError = GetNewsArticlesUseCase(faeNewsListRepositoryError)
        val articles = getNewsArticlesUseCaseError.invoke()
        articles.collect {
            if (it is Resource.Error) {
                assertEquals(expectedError, it.message)
            }
        }

    }

}