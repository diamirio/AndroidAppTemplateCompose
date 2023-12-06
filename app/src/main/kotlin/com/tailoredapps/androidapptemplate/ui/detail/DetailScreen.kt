package com.tailoredapps.androidapptemplate.ui.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tailoredapps.androidapptemplate.base.ui.scaffold.AppScaffold

@Composable
fun DetailScreen(id: Int?) {
    AppScaffold(title = id.toString()) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            Text(text = id.toString())
        }
    }
}