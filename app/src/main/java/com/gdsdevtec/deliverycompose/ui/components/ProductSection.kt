package com.gdsdevtec.deliverycompose.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
fun ProductSection(
    modifier: Modifier = Modifier,
    title: String = "Default",
    products: List<Product>,
) = Section(title = {
    Text(
        text = title,
        fontWeight = FontWeight(400),
        modifier = Modifier.padding(all = 16.dp),
        style = TextStyle(fontSize = 20.sp)
    )
}, content = {
    Row(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        for (p in products) ChangeComposable(product = p)
        Spacer(modifier = Modifier)
    }
}, modifier = modifier
)

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() = ProductSection(
    title = "default",
    products = sampleProducts
)


