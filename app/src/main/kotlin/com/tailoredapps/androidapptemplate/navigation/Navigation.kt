package com.tailoredapps.androidapptemplate.navigation

import androidx.navigation.NavBackStackEntry


/**
 * Extensions
 */
fun NavBackStackEntry.getIntArg(key: String): Int? = arguments?.getString(key)?.toIntOrNull()

fun NavBackStackEntry.getLongArg(key: String): Long? = arguments?.getString(key)?.toLongOrNull()

fun NavBackStackEntry.getStringArg(key: String): String? = arguments?.getString(key)
