package com.gdsdevtec.deliverycompose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdsdevtec.deliverycompose.R
import com.gdsdevtec.deliverycompose.ui.theme.Purple
import com.gdsdevtec.deliverycompose.ui.theme.Teal


@Composable
fun ProductItem2(modifier: Modifier = Modifier) = Surface(
    modifier,
    shape = RoundedCornerShape(15.dp),
    elevation = 8.dp
) {
    Row(
        modifier = Modifier
            .widthIn(250.dp, 500.dp)
            .height(200.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .height(100.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Purple, Teal
                        )
                    )
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "img",
                Modifier
                    .size(100.dp)
                    .offset(x = 50.dp, y = (-50).dp)
                    .clip(shape = CircleShape)
                    .align(Alignment.BottomCenter)
            )
        }
        Spacer(modifier = Modifier.width(50.dp))
        Row(modifier = Modifier.padding(16.dp, top = 20.dp, end = 20.dp)) {
            Text(
                text = LoremIpsum(50).values.first(),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700)
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItem2Preview() = ProductItem2()
