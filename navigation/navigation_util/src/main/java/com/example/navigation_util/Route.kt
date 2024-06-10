package com.example.navigation_util

sealed class Route(val name: String) {
    data object NewsListScreen : Route("NewsList")
    data object NewsDetailsScreen : Route("NewsDetails")
}