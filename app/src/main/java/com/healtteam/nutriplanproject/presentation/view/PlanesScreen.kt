package com.healtteam.nutriplanproject.presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.healtteam.nutriplanproject.presentation.viewmodel.PlanesViewModel
import androidx.compose.foundation.text.BasicText

@Composable
fun PlanesScreen(viewModel: PlanesViewModel) {
    val planes by viewModel.planes

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(planes) { plan ->
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                BasicText(text = "Nombre del plan: ${plan.nombre}")
                BasicText(text = "Descripción: ${plan.descripcion}")
                BasicText(text = "Duración: ${plan.duracion} días")
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}