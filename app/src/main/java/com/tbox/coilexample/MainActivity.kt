package com.tbox.coilexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.tbox.coilexample.ui.theme.CoilExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imageUrl = 
        enableEdgeToEdge()
        setContent {
            CoilExampleTheme {

            }
        }
    }
}



