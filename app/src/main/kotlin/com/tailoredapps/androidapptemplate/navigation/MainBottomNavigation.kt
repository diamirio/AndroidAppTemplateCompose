package com.tailoredapps.androidapptemplate.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MainBottomNavigation(
    navController: NavController
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    BottomAppBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        BottomNav.values().forEach { item ->
            val selected =
                item.navGraph.screens.map { it.route }.contains(currentDestination?.route)
            NavigationBarItem(
                icon = {
                    if (selected) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = null,
                        )
                    }
                },
                selected = selected,
                onClick = {
                    navController.navigate(item.navGraph.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
