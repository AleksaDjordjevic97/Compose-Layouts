package com.aleksadjordjevic.composelayouts.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aleksadjordjevic.composelayouts.ui.InstagramUIScreen


class InstagramUIActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramUIScreen()
        }
    }
}
