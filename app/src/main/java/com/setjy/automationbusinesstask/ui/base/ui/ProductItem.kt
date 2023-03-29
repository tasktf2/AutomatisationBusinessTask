package com.setjy.automationbusinesstask.ui.base.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.setjy.automationbusinesstask.R
import com.setjy.automationbusinesstask.ui.model.ProductUI
import com.setjy.automationbusinesstask.ui.theme.BlackTransparent

@Composable
fun ProductItem(cardItem: ProductUI) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .aspectRatio(1f)
            .clip(MaterialTheme.shapes.small)
    ) {
        Image(
            bitmap = cardItem.itemImage?.asImageBitmap()
                ?: ImageBitmap.imageResource(id = R.drawable.ic_launcher_background),
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        CardShadow(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
        CardName(
            cardItem = cardItem,
            modifier = Modifier.align(Alignment.BottomStart)
        )
        CardPrice(
            cardItem = cardItem,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Composable
private fun CardShadow(modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxHeight(0.6f)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, BlackTransparent),
                )
            )
    )
}


@Composable
private fun CardName(cardItem: ProductUI, modifier: Modifier) {
    Text(
        text = cardItem.itemName,
        style = MaterialTheme.typography.body2,
        color = Color.White,
        modifier = modifier
            .padding(start = 10.dp)
            .fillMaxWidth(0.7f)
            .fillMaxHeight(0.4f)
    )
}

@Composable
private fun CardPrice(cardItem: ProductUI, modifier: Modifier) {
    Text(
        text = buildString {
            append(cardItem.itemPrice)
            append(" р.")
        },
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.body2,
        color = Color.White,
        fontSize = 10.sp,
        modifier = modifier
            .padding(top = 10.dp, end = 10.dp)
            .fillMaxHeight(0.4f)
            .fillMaxWidth(0.25f)
    )
}
