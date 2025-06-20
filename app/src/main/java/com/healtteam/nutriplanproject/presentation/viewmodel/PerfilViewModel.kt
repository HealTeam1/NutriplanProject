package com.healtteam.nutriplanproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.healtteam.nutriplanproject.domain.model.Nutricionista
import com.healtteam.nutriplanproject.domain.repository.NutricionistaRepository

class PerfilViewModel(private val repo: NutricionistaRepository) : ViewModel() {
    var perfil by mutableStateOf<Nutricionista?>(null)
        private set

    init {
        viewModelScope.launch {
            perfil = repo.getNutricionistas().firstOrNull()
        }
    }
}