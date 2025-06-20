package com.healtteam.nutriplanproject.presentation.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.healtteam.nutriplanproject.presentation.viewmodel.PacientesViewModel
import androidx.compose.foundation.text.BasicText

@Composable
fun PacientesScreen(viewModel: PacientesViewModel) {
    val pacientes by viewModel.pacientes

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pacientes) { paciente ->
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                BasicText(text = "Nombre: ${paciente.nombre}")
                BasicText(text = "Edad: ${paciente.edad}")
                BasicText(text = "Correo: ${paciente.correo}")
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}