package com.tailoredapps.androidapptemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.tailoredapps.androidapptemplate.navigation.screens.detailRoute
import com.tailoredapps.androidapptemplate.navigation.screens.detailScreen
import com.tailoredapps.androidapptemplate.navigation.screens.mainRoute
import com.tailoredapps.androidapptemplate.navigation.screens.mainScreen
import com.tailoredapps.androidapptemplate.navigation.screens.overviewRoute
import com.tailoredapps.androidapptemplate.navigation.screens.overviewScreen

enum class NavHosts(val route: String) {
    APP("nav_host_app"),
    Main("nav_host_main")
}

enum class NavGraphs(
    val route: String
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
        route = NavHosts.APP.route,
        startDestination = NavGraphs.Main.route
    ) {
        navigation(startDestination = mainRoute(), route = NavGraphs.Main.route) {
            mainScreen { mainNavHostController ->
                mainNavHostController.MainNavHost()
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
        startDestination = NavGraphs.Overview.route
    ) {
        navigation(startDestination = overviewRoute(), route = NavGraphs.Overview.route) {
            overviewScreen { id ->
                this@MainNavHost.navigate(detailRoute(id))
            }

            detailScreen()
        }
    }
}