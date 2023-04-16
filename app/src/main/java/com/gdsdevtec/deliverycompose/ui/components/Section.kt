package com.gdsdevtec.deliverycompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Section(
    modifier : Modifier = Modifier,
    title: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    Column(modifier) {
        title()
        Spacer(modifier = Modifier.height(16.dp))
        content()
    }
}

@Preview
@Composable
fun SectionPreview() {
    Section(title = { Text(text = "alo brasil")}) {

    }
}