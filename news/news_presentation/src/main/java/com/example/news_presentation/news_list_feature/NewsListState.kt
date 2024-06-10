package com.example.news_presentation.news_list_feature

sealed interface NewsListState<out T> {

    data class Success<T>(val data: T) : NewsListState<T>
    data class Error(val message: String) : NewsListState<Nothing>
    data object Loading : NewsListState<Nothing>
}

