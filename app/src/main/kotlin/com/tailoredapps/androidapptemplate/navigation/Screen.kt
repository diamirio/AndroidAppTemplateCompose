package com.tailoredapps.androidapptemplate.navigation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.tailoredapps.androidapptemplate.R
import com.tailoredapps.androidapptemplate.ui.detail.DetailScreen
import com.tailoredapps.androidapptemplate.ui.main.MainScreen
import com.tailoredapps.androidapptemplate.ui.overview.OverviewScreen


sealed class Screen {
    @get:StringRes
    abstract val titleRes: Int

    abstract val route: String

    @Composable
    abstract fun View(
        navHostController: NavHostController,
        outerNavHostController: NavHostController?,
        navBackStackEntry: NavBackStackEntry
    )

    object Main : Screen() {
        override val titleRes: Int = R.string.screen_overview
        override val route: String = "overview"

        @Composable
        override fun View(
            navHostController: NavHostController,
            outerNavHostController: NavHostController?,
            navBackStackEntry: NavBackStackEntry
        ) = MainScreen { mainNavHostController ->
            mainNavHostController.MainNavHost(navHostController)
        }
    }

    object Overview : Screen() {
        override val titleRes: Int = R.string.screen_overview
        override val route: String = "overview"

        @Composable
        override fun View(
            navHostController: NavHostController,
            outerNavHostController: NavHostController?,
            navBackStackEntry: NavBackStackEntry
        ) = OverviewScreen { id ->
            navHostController.navigate(Detail.route(id))
        }
    }

    object Detail : Screen() {
        override val titleRes: Int = R.string.screen_overview
        override val route: String = "detail/{id}"

        @Composable
        override fun View(
            navHostController: NavHostController,
            outerNavHostController: NavHostController?,
            navBackStackEntry: NavBackStackEntry
        ) = DetailScreen(id = navBackStackEntry.arguments?.getString("id")?.toInt())

        fun route(id: Int) = route.replace("{id}", id.toString())
    }
}