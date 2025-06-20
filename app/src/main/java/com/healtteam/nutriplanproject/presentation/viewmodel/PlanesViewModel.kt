package com.healtteam.nutriplanproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.healtteam.nutriplanproject.domain.model.PlanAlimenticio
import com.healtteam.nutriplanproject.domain.repository.NutricionistaRepository

class PlanesViewModel(private val repo: NutricionistaRepository) : ViewModel() {
    var planes by mutableStateOf<List<PlanAlimenticio>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            val nutricionistas = repo.getNutricionistas()
            planes = nutricionistas.firstOrNull()?.planesPersonalizados ?: emptyList()
        }
    }
}