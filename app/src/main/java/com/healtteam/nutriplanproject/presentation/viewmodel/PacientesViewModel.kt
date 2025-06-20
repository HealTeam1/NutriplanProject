package com.healtteam.nutriplanproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.healtteam.nutriplanproject.domain.model.Paciente
import com.healtteam.nutriplanproject.domain.repository.NutricionistaRepository

class PacientesViewModel(private val repo: NutricionistaRepository) : ViewModel() {
    var pacientes by mutableStateOf<List<Paciente>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            val nutricionistas = repo.getNutricionistas()
            pacientes = nutricionistas.firstOrNull()?.pacientes ?: emptyList()
        }
    }
}