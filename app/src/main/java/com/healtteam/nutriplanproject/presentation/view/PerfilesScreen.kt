package com.healtteam.nutriplanproject.presentation.view


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.healtteam.nutriplanproject.presentation.viewmodel.PerfilViewModel

@Composable
fun PerfilScreen(viewModel: PerfilViewModel) {
    val perfil by viewModel.perfil .collectAsState()
