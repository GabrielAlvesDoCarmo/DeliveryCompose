package com.gdsdevtec.deliverycompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdsdevtec.deliverycompose.model.Product
import com.gdsdevtec.deliverycompose.sample.sampleProducts


@Composable
fun ProductSection2(
    modifier: Modifier = Modifier,
    title: String,
    products: List<Product>,
) = Section(
    title = {
        Text(
            text = title,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
            style = TextStyle(fontSize = 20.sp)
        )
    },
    content = {
        LazyRow(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products) { p -> ChangeComposable(p) }
        }
    },
    modifier = modifier
)

@Preview(showBackground = true)
@Composable
private fun ProductSection2Preview() = ProductSection2(title = "teste",products = sampleProducts)