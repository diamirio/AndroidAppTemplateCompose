package com.tailoredapps.androidapptemplate.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost


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
        graph(this@AppNavHost, NavGraphs.Main)
    }
}


/**
 * Main Nav Host
 */
@Composable
fun NavHostController.MainNavHost(outerNavHostController: NavHostController) {
    NavHost(
        navController = this,
        route = NavHosts.Main.route,
        startDestination = NavGraphs.Overview.route
    ) {
        graph(this@MainNavHost, NavGraphs.Overview)
    }
}