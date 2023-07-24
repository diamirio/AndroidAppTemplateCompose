package com.tailoredapps.androidapptemplate.navigation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.tailoredapps.androidapptemplate.ui.main.MainScreen


private const val MAIN_ROUTE: String = "main"

internal fun mainRoute(): String = MAIN_ROUTE

internal fun NavGraphBuilder.mainScreen(initNavigation: @Composable (navHostController: NavHostController) -> Unit) {
    composable(MAIN_ROUTE) {
        MainScreen(initNavigation = initNavigation)
    }
}