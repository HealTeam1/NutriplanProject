package com.healtteam.nutriplanproject.domain.repository

import com.healtteam.nutriplanproject.domain.model.Nutricionista

interface NutricionistaRepository {
    suspend fun getNutricionistas(): List<Nutricionista>
}