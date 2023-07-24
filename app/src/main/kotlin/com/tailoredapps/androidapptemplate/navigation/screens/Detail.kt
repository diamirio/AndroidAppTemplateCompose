package com.tailoredapps.androidapptemplate.navigation.screens

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.tailoredapps.androidapptemplate.navigation.getIntArg
import com.tailoredapps.androidapptemplate.ui.detail.DetailScreen


private const val DETAIL_ROUTE_WITH_ARGS: String = "detail/{id}"

internal fun detailRoute(id: Int) = DETAIL_ROUTE_WITH_ARGS.replace("{id}", id.toString())

internal fun NavGraphBuilder.detailScreen() {
    composable(DETAIL_ROUTE_WITH_ARGS) { navBackStackEntry ->
        DetailScreen(id = navBackStackEntry.getIntArg("id"))
    }
}

