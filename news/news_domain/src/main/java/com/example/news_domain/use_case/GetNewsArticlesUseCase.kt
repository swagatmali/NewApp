package com.example.news_domain.use_case

import com.example.common_util.Resource
import com.example.news_domain.model.Article
import com.example.news_domain.repository.NewsListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNewsArticlesUseCase(private val newsRepository: NewsListRepository) {

    operator fun invoke(): Flow<Resource<List<Article>>> = flow {
        try {
            emit(Resource.Success(data = newsRepository.getNewsArticles()))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}