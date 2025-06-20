package com.healtteam.nutriplanproject.data.repository

import com.healtteam.nutriplanproject.data.local.NutricionistaDao
import com.healtteam.nutriplanproject.data.model.NutricionistaEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NutricionistaRepository(
    private val nutricionistaDao: NutricionistaDao
) {
    suspend fun getAllNutricionistas(): List<NutricionistaEntity> = withContext(Dispatchers.IO) {
        nutricionistaDao.getAllNutricionistas()
    }

    suspend fun insertNutricionista(nutricionista: NutricionistaEntity) = withContext(Dispatchers.IO) {
        nutricionistaDao.insertNutricionista(nutricionista)
    }

    suspend fun deleteNutricionista(nutricionista: NutricionistaEntity) = withContext(Dispatchers.IO) {
        nutricionistaDao.deleteNutricionista(nutricionista)
    }
}