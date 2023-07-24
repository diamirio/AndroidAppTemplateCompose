package com.tailoredapps.androidapptemplate.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation


enum class NavHosts(val route: String) {
    APP("nav_host_app"),
    Main("nav_host_main")
}

enum class NavGraphs(
    val route: String,
    val screens: List<Screen>
) {
    Main("nav_main", listOf(Screen.Main)),
    Overview("nav_overview", listOf(Screen.Overview, Screen.Detail)),
}


enum class BottomNav(
    val navGraph: NavGraphs,
    @DrawableRes val icon: Int,
    @StringRes val title: Int = navGraph.screens[0].titleRes
) {
    Overview(NavGraphs.Overview, android.R.drawable.ic_menu_view),
}


/**
 * Extensions
 */
fun NavGraphBuilder.graph(
    navHostController: NavHostController,
    graph: NavGraphs
) {
    navigation(startDestination = graph.screens.first().route, route = graph.route) {
        for (screen in graph.screens) {
            composableOf(navHostController, screen)
        }
    }
}

fun NavGraphBuilder.graph(
    navHostController: NavHostController,
    outerNavHostController: NavHostController,
    graph: NavGraphs
) {
    navigation(startDestination = Screen.Main.route, route = NavGraphs.Main.route) {
        for (screen in graph.screens) {
            composableOf(navHostController, outerNavHostController, Screen.Main)
        }
    }
}

internal fun NavGraphBuilder.composableOf(
    navHostController: NavHostController,
    screen: Screen
) = this.composableOf(navHostController, null, screen)

private fun NavGraphBuilder.composableOf(
    navHostController: NavHostController,
    outerNavHostController: NavHostController?,
    screen: Screen
) {
    composable(screen.route) { screen.View(navHostController, outerNavHostController, it) }
}