package com.tailoredapps.androidapptemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.tailoredapps.androidapptemplate.navigation.destinations.ROUTE_MAIN
import com.tailoredapps.androidapptemplate.navigation.destinations.ROUTE_OVERVIEW
import com.tailoredapps.androidapptemplate.navigation.destinations.detailScreen
import com.tailoredapps.androidapptemplate.navigation.destinations.mainScreen
import com.tailoredapps.androidapptemplate.navigation.destinations.navigateToDetail
import com.tailoredapps.androidapptemplate.navigation.destinations.overviewScreen

enum class NavHosts(val route: String) {
    App("nav_host_app"),
    Main("nav_host_main"),
}

enum class NavGraphs(
    val route: String,
) {
    Main("nav_main"),
    Overview("nav_overview"),
}

/**
 * App's Nav Host
 */
@Composable
fun NavHostController.AppNavHost() {
    NavHost(
        navController = this,
        route = NavHosts.App.route,
        startDestination = NavGraphs.Main.route,
    ) {
        navigation(startDestination = ROUTE_MAIN, route = NavGraphs.Main.route) {
            mainScreen { navHostController ->
                navHostController.MainNavHost()
            }
        }
    }
}

/**
 * Main Nav Host
 */
@Composable
fun NavHostController.MainNavHost() {
    NavHost(
        navController = this,
        route = NavHosts.Main.route,
        startDestination = NavGraphs.Overview.route,
    ) {
        navigation(startDestination = ROUTE_OVERVIEW, route = NavGraphs.Overview.route) {
            overviewScreen(
                onListElementClicked = this@MainNavHost::navigateToDetail,
            )

            detailScreen()
        }
    }
}
