package com.tailoredapps.androidapptemplate.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.tailoredapps.androidapptemplate.base.ui.scaffold.AppScaffold


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
    initNavigation: @Composable (navHostController: NavHostController) -> Unit,
) {
    val mainNavHostController = rememberNavController()

    AppScaffold(
        contentWindowInsets = WindowInsets(
            0,
            0,
            0,
            0
        ) // Workaround because of Compose bug when combining imePadding and scaffold padding.  See https://issuetracker.google.com/issues/249727298?pli=1
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = paddingValues.calculateBottomPadding()) // Padding for bottomBar for all screens
                .consumeWindowInsets(paddingValues) // Workaround because of Compose bug when combining imePadding and scaffold padding. See https://issuetracker.google.com/issues/249727298?pli=1
        ) {
            initNavigation(mainNavHostController)
        }
    }
}