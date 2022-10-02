package com.aleksadjordjevic.composelayouts.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.aleksadjordjevic.composelayouts.R
import com.aleksadjordjevic.composelayouts.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MainScreen(
                context = this
            ) {
                val intent = Intent(this, LayoutsActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
        }
    }
}


