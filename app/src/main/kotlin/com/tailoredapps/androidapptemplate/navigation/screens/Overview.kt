package com.tailoredapps.androidapptemplate.navigation.screens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tailoredapps.androidapptemplate.ui.overview.OverviewScreen


private const val OVERVIEW_ROUTE: String = "overview"

internal fun overviewRoute(): String = OVERVIEW_ROUTE

internal fun NavGraphBuilder.overviewScreen(onListElementClicked: (Int) -> Unit) {
    composable(OVERVIEW_ROUTE) {
        OverviewScreen(onListElementClicked = onListElementClicked)
    }
}