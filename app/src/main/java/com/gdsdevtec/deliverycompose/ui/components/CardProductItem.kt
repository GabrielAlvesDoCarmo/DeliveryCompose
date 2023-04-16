package com.gdsdevtec.deliverycompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.gdsdevtec.deliverycompose.R
import com.gdsdevtec.deliverycompose.extensions.toBrazilianCurrency
import com.gdsdevtec.deliverycompose.model.Product
import com.gdsdevtec.deliverycompose.sample.sampleProducts
import com.gdsdevtec.deliverycompose.ui.theme.DeliveryComposeTheme

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp,
    textColor: Color = Color.White,
    textDescriptionColor: Color = Color.Black,
    isExpanded : Boolean = false
) {
    var expanded by rememberSaveable {
        mutableStateOf(isExpanded)
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable { expanded = !expanded },
        elevation = elevation
    ) {
        Column {
            AsyncImage(
                model = product.image, contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder)
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primaryVariant)
                    .padding(16.dp)
            ) {
                Text(text = product.name, style = TextStyle(color = textColor))
                Text(
                    text = product.price.toBrazilianCurrency(),
                    style = TextStyle(color = textColor)
                )
            }
            if (expanded){
                product.description?.let { description ->
                    Text(
                        text = description,
                        modifier = Modifier.padding(16.dp),
                        style = TextStyle(color = textDescriptionColor),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CardProductItemPreview() {
    DeliveryComposeTheme {
        Surface {
            CardProductItem(product = sampleProducts.first())
        }
    }
}
