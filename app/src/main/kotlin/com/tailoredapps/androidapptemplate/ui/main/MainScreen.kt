package com.tailoredapps.androidapptemplate.ui.main

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(initNavigation: @Composable (navHostController: NavHostController) -> Unit) {
    val mainNavHostController = rememberNavController()

    Surface {
        initNavigation(mainNavHostController)
    }
}
