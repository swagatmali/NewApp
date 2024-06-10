package com.example.news_data.di

import com.example.news_data.network.NewsListApiService
import com.example.news_data.repository.NewsRepoImpl
import com.example.news_domain.repository.NewsListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object NewsListDataModule {

    @Provides
    fun provideNewsApiService(retrofit: Retrofit): NewsListApiService {
        return retrofit.create(NewsListApiService::class.java)
    }

    @Provides
    fun provideNewsRepository(apiService: NewsListApiService): NewsListRepository {
        return NewsRepoImpl(apiService)
    }

}