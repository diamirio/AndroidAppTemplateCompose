package com.tailoredapps.androidapptemplate.navigation

import androidx.navigation.NavBackStackEntry

/**
 * Extensions
 */
fun NavBackStackEntry.getIntArgOrNull(key: String): Int? = arguments?.getString(key)?.toIntOrNull()

fun NavBackStackEntry.getLongArgOrNull(key: String): Long? =
    arguments?.getString(key)?.toLongOrNull()

fun NavBackStackEntry.getStringArgOrNull(key: String): String? = arguments?.getString(key)
