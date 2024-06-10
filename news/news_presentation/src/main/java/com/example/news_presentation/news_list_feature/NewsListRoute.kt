package com.example.news_presentation.news_list_feature

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.news_domain.model.Article
import com.example.news_presentation.base.ShowError
import com.example.news_presentation.base.ShowLoading

@Composable
fun NewsListRoute(
    onNewsClick: (url: Article) -> Unit,
    newsListViewModel: NewsListViewModel = hiltViewModel()
) {
    val newsListState: NewsListState<List<Article>> by newsListViewModel.newsArticles.collectAsState()
    NewsListState(newsListState = newsListState, onNewsClick, onRetryClick = {
        newsListViewModel.fetchNews()
    })
}

@Composable
fun NewsListState(
    newsListState: NewsListState<List<Article>>,
    onNewsClick: (url: Article) -> Unit,
    onRetryClick: () -> Unit
) {
    when (newsListState) {
        is NewsListState.Loading -> {
            ShowLoading()
        }
        is NewsListState.Success -> {
            NewsListScreen(newsListState.data, onNewsClick)
        }
        is NewsListState.Error -> {
            ShowError(newsListState.message, onRetryClick)
        }
    }
}