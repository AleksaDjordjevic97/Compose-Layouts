package com.aleksadjordjevic.composelayouts

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aleksadjordjevic.composelayouts.activities.InstagramUIActivity
import com.aleksadjordjevic.composelayouts.activities.MeditationUIActivity

@Composable
fun LayoutsScreen(
    context: Context
){
    val meditationUiPainter = painterResource(id = R.drawable.meditation_ui)
    val instagramUiPainter = painterResource(id = R.drawable.instagram_ui)
    val eGroceryUiPainter = painterResource(id = R.drawable.e_grocery_store_ui)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.25f)) {

            LayoutCell(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(10.dp)
                    .clickable {
                        val intent = Intent(context, MeditationUIActivity::class.java)
                        context.startActivity(intent)
                    },
                bgdPainter = meditationUiPainter)

            LayoutCell(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(10.dp)
                    .clickable {
                        val intent = Intent(context, InstagramUIActivity::class.java)
                        context.startActivity(intent)
                    },
                bgdPainter = instagramUiPainter)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.33f)) {

            LayoutCell(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .padding(10.dp),
                bgdPainter = eGroceryUiPainter)

        }


    }
}

@Composable
fun LayoutCell(
    modifier: Modifier,
    bgdPainter: Painter
){

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp) {

        Image(
            painter = bgdPainter,
            contentDescription = "Layout Cell Background",
            contentScale = ContentScale.Crop)
    }
}