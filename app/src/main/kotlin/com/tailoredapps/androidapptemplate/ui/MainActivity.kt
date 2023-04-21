/*
 * Copyright 2020 Tailored Media GmbH.
 * Created by Florian Schuster.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tailoredapps.androidapptemplate.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.tailoredapps.androidapptemplate.base.ui.theme.AppTheme
import com.tailoredapps.androidapptemplate.navigation.AppNavHost

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val view = LocalView.current
            val darkTheme = isSystemInDarkTheme()

            MainView()

            SideEffect {
                val window = this.window

                window.statusBarColor = Color.Transparent.toArgb()
                window.navigationBarColor = Color.Transparent.toArgb()

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    window.isNavigationBarContrastEnforced = false
                }

                val windowsInsetsController = WindowCompat.getInsetsController(window, view)

                windowsInsetsController.isAppearanceLightStatusBars = !darkTheme
                windowsInsetsController.isAppearanceLightNavigationBars = !darkTheme
            }
        }
    }
}

@Composable
fun MainView() {
    AppTheme {
        val navController = rememberNavController()
        navController.AppNavHost()
    }
}

@Preview(name = "MainView")
@Composable
fun MainViewPreview() {
    MainView()
}

@Preview(name = "MainView Night", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MainViewPreviewNight() {
    MainView()
}
