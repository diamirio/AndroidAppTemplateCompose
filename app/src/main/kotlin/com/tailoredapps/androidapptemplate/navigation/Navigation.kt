package com.tailoredapps.androidapptemplate.navigation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.tailoredapps.androidapptemplate.R
import com.tailoredapps.androidapptemplate.ui.overview.OverviewScreen

sealed class Screen {
    @get:StringRes
    abstract val titleRes: Int

    abstract val route: String

    @Composable
    abstract fun View(navHostController: NavHostController, navBackStackEntry: NavBackStackEntry)

    object Overview : Screen() {
        override val titleRes: Int = R.string.screen_overview
        override val route: String = "overview"

        @Composable
        override fun View(navHostController: NavHostController, navBackStackEntry: NavBackStackEntry) = OverviewScreen()
    }
}

enum class NestedNav(val route: String) {
    Main("nav_main"),
}