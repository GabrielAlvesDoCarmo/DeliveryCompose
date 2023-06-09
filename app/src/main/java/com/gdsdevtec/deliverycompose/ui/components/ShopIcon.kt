package com.gdsdevtec.deliverycompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gdsdevtec.deliverycompose.R
import com.gdsdevtec.deliverycompose.model.Shop
import com.gdsdevtec.deliverycompose.sample.sampleShops

@Composable
fun ShopIcon(
    modifier: Modifier = Modifier,
    shop: Shop,
) = Surface(modifier) {
    Column(
        Modifier
            .heightIn(150.dp, 200.dp)
            .width(100.dp)
    ) {
        val imageSize = 100.dp
        AsyncImage(
            model = shop.logo,
            contentDescription = null,
            modifier = Modifier.size(imageSize).clip(shape = CircleShape),
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.placeholder)
        )
        Text(
            text = shop.name,
            fontSize = 16.sp,
            maxLines = 2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun ShopIconPreview() = ShopIcon(shop = sampleShops.first())
