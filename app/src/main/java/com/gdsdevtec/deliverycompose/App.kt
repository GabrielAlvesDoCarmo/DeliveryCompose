package com.gdsdevtec.deliverycompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gdsdevtec.deliverycompose.sample.sampleSections
import com.gdsdevtec.deliverycompose.ui.screen.home.HomeScreen
import com.gdsdevtec.deliverycompose.ui.screen.home.HomeScreenUiState
import com.gdsdevtec.deliverycompose.ui.theme.DeliveryComposeTheme


@Composable
fun App(
    fabClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    DeliveryComposeTheme {
        Scaffold(floatingActionButton = {
            FloatingActionButton(
                onClick = { fabClick() },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }) {
            Box(modifier = Modifier.padding(it)) {
                content()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() = App { HomeScreen(state = HomeScreenUiState(sections = sampleSections,))}
