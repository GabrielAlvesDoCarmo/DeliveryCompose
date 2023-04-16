package com.gdsdevtec.deliverycompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gdsdevtec.deliverycompose.R
import com.gdsdevtec.deliverycompose.extensions.toBrazilianCurrency
import com.gdsdevtec.deliverycompose.model.Product
import com.gdsdevtec.deliverycompose.sample.sampleProducts
import com.gdsdevtec.deliverycompose.ui.theme.Purple
import com.gdsdevtec.deliverycompose.ui.theme.Teal


@Composable
fun ChangeComposable(product: Product, modifier: Modifier = Modifier) =
    Surface(
        modifier,
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .heightIn(200.dp, 250.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageSize)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Purple, Teal
                            )
                        )
                    )
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = "img",

                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight(700)
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
            product.description?.let { description ->
                Text(
                    text = description,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .background(Purple),
                    color = Color.White,
                    style = TextStyle(
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }

@Preview(showBackground = true)
@Composable
private fun ChangeComposablePreview() = ChangeComposable(
    sampleProducts.first()
)