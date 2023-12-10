package com.tailoredapps.androidapptemplate.navigation.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.tailoredapps.androidapptemplate.ui.main.MainScreen

internal const val ROUTE_MAIN: String = "main"

internal fun NavGraphBuilder.mainScreen(
    initNavigation: @Composable (navHostController: NavHostController) -> Unit,
) {
    composable(ROUTE_MAIN) {
        MainScreen(initNavigation = initNavigation)
    }
}

internal fun NavController.navigateToMain() = this.navigate(ROUTE_MAIN)
