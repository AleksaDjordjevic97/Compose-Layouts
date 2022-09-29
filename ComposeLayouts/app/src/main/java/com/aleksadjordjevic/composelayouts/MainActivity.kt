package com.aleksadjordjevic.composelayouts

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val logoPainter = painterResource(id = R.drawable.compose_logo)
            val buttonText = stringResource(R.string.main_activity_button_text)
            val buttonColor = colorResource(R.color.main_activity_button_color)
            val buttonTextColor = colorResource(R.color.main_activity_button_text_color)
            val buttonTextSize = resources.getInteger(R.integer.activity_main_button_text_size)

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Spacer(
                        modifier = Modifier
                        .fillMaxHeight(0.1f))
                    Image(
                        painter = logoPainter,
                        contentDescription = "Compose Logo",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth(0.75f)
                            .aspectRatio(1f))
                    Spacer(
                        modifier = Modifier
                            .fillMaxHeight(0.5f))
                    startButton(
                        text = buttonText,
                        textColor = buttonTextColor,
                        textSize = buttonTextSize,
                        backgroundColor = buttonColor,
                        onClickEvent = {
                            val intent = Intent(this@MainActivity,LayoutsActivity::class.java)
                            startActivity(intent)
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        })
                }

        }
    }
}

@Composable
fun startButton(
    text:String,
    textColor:Color,
    textSize:Int,
    backgroundColor:Color,
    onClickEvent:() -> Unit
){
    Button(onClick = {onClickEvent()},
        shape = RoundedCornerShape(20.dp),
        elevation = ButtonDefaults
            .elevation(
                defaultElevation = 6.dp,
                pressedElevation = 8.dp
            ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        ),
        modifier = Modifier
            .fillMaxWidth(0.66f)
            .fillMaxHeight(0.25f)) {

        Text(
            text = text,
            textAlign = TextAlign.Center,
            color = textColor,
            fontSize = textSize.sp)
    }
}

