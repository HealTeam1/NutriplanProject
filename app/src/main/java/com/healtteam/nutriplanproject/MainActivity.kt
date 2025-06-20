package com.healtteam.nutriplanproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.healtteam.nutriplanproject.presentation.navigation.Home
import com.healtteam.nutriplanproject.ui.theme.NutriplanProjectTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriplanProjectTheme {
                Home()
            }
        }
    }
}