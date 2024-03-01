package com.example.compose_sample.route

sealed class Screen(val route: String) {
    object DashboardScreen : Screen("dashboardScreen")
    object ScreenTwo : Screen("ScreenTwo")
    object ScreenThree : Screen("ScreenThree")
    object ScreenFour : Screen("ScreenFour")
    object ScreenFive : Screen("ScreenFive")
    object ScreenSix : Screen("ScreenSix")
}
