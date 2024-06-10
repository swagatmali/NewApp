package com.example.navigation_util

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.news_presentation.base.SharedViewModel
import com.example.news_presentation.news_details_feature.NewsDetailsScreen
import com.example.news_presentation.news_list_feature.NewsListRoute

@Composable
fun AppNavHost() {
    val sharedViewModel: SharedViewModel = viewModel()
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.NewsListScreen.name
    ) {
        composable(route = Route.NewsListScreen.name) {
            NewsListRoute(onNewsClick = {
                sharedViewModel.addArticle(it)
                navController.navigate(Route.NewsDetailsScreen.name)
            })
        }
        composable(route = Route.NewsDetailsScreen.name ) {
                NewsDetailsScreen(sharedViewModel.article)
        }
    }
}