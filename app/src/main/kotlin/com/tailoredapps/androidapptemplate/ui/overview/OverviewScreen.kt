package com.tailoredapps.androidapptemplate.ui.overview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tailoredapps.androidapptemplate.R
import com.tailoredapps.androidapptemplate.base.ui.scaffold.AppScaffold
import com.tailoredapps.androidapptemplate.base.ui.theme.AppTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun OverviewScreen(
    viewModel: OverviewViewModel = getViewModel(),
    onListElementClicked: (id: Int) -> Unit
) {
    val viewModelState by viewModel.state.collectAsStateWithLifecycle()

    OverviewView(
        title = stringResource(id = R.string.app_name),
        onListElementClicked = onListElementClicked
    )
}

@Composable
private fun OverviewView(
    title: String,
    onListElementClicked: (id: Int) -> Unit
) {
    AppScaffold(title = title) { contentPadding ->
        LazyColumn(
            modifier = Modifier.padding(contentPadding)
        ) {
            items((0..500).toList()) {
                Text(
                    text = it.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onListElementClicked(it) }
                        .padding(AppTheme.dimens.dimen16)
                )
            }
        }
    }
}

@Preview
@Composable
private fun OverviewPreview() {
    AppTheme {
        OverviewView(
            title = stringResource(id = R.string.app_name),
            onListElementClicked = {}
        )
    }
}

