package com.example.news_presentation.news_list_feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_util.Resource
import com.example.common_util.network.NetworkHelper
import com.example.news_domain.model.Article
import com.example.news_domain.use_case.GetNewsArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val getNewsArticlesUseCase: GetNewsArticlesUseCase,
    private val networkHelper: NetworkHelper,
) :
    ViewModel() {

    private val _newsArticles =
        MutableStateFlow<NewsListState<List<Article>>>(NewsListState.Loading)
    val newsArticles: StateFlow<NewsListState<List<Article>>> = _newsArticles

    private fun checkInternetConnection(): Boolean = networkHelper.isNetworkConnected()

    init {
       fetchNews()
    }

    fun fetchNews(){
        if (checkInternetConnection()) {
            getNewsArticles()
        } else {
            _newsArticles.value = NewsListState.Error("No Internet Connection")
        }
    }

    private fun getNewsArticles() {
        getNewsArticlesUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _newsArticles.value = NewsListState.Loading
                }

                is Resource.Success -> {
                    _newsArticles.value = NewsListState.Success(it.data)
                }

                else -> {
                    _newsArticles.value = NewsListState.Error(it.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}