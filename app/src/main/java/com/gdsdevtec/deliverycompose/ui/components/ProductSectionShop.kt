package com.gdsdevtec.deliverycompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdsdevtec.deliverycompose.model.Shop
import com.gdsdevtec.deliverycompose.sample.sampleShops

@Composable
fun ProductSectionShop(
    modifier: Modifier = Modifier,
    title: String,
    shop: List<Shop>,
) = Section(
    title = {
            Text(text = title, fontSize = 20.sp,modifier = Modifier.padding(start = 16.dp,top = 8.dp))
    },
    content = {
        LazyRow(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(shop) { shop -> ShopIcon(shop = shop) }
        }
    },
    modifier = modifier
)

@Preview(showBackground = true)
@Composable
fun ProductSectionShopPreview() = ProductSectionShop(title = "colocando o titulo", shop = sampleShops.toList())