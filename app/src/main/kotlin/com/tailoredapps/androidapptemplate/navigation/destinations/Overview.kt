package com.tailoredapps.androidapptemplate.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tailoredapps.androidapptemplate.ui.overview.OverviewScreen

internal const val ROUTE_OVERVIEW: String = "overview"

internal fun NavGraphBuilder.overviewScreen(onListElementClicked: (Int) -> Unit) {
    composable(ROUTE_OVERVIEW) {
        OverviewScreen(onListElementClicked = onListElementClicked)
    }
}

internal fun NavController.navigateToOverview() = this.navigate(ROUTE_OVERVIEW)
