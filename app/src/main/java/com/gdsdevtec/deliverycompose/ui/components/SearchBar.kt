package com.gdsdevtec.deliverycompose.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchValue: String,
    onChangeValue: (String) -> Unit,
    label: String = "Oq voce procura?",
    icon: ImageVector = Icons.Default.Search,
    iconDescription: String = "pesquisar",
    placeholder: String = "Pesquisar Produto",
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = searchValue,
        onValueChange = { onChangeValue(it) },
        label = { Text(text = label) },
        shape = RoundedCornerShape(100),
        leadingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription
            )
        },
        placeholder = { Text(text = placeholder) }
    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() = SearchBar(
    searchValue = "",
    onChangeValue = {},
)