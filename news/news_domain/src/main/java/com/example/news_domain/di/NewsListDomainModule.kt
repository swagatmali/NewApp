package com.example.news_domain.di

import com.example.news_domain.repository.NewsListRepository
import com.example.news_domain.use_case.GetNewsArticlesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object NewsListDomainModule {

    @Provides
    fun provideNewsListUseCase(newsListRepository: NewsListRepository): GetNewsArticlesUseCase {
        return GetNewsArticlesUseCase(newsListRepository)
    }
}