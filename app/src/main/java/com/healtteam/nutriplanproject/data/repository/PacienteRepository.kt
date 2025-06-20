package com.healtteam.nutriplanproject.data.repository

import com.healtteam.nutriplanproject.data.local.PacienteDao
import com.healtteam.nutriplanproject.data.model.PacienteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PacienteRepository(
    private val pacienteDao: PacienteDao
) {
    suspend fun getAllPacientes(): List<PacienteEntity> = withContext(Dispatchers.IO) {
        pacienteDao.getAllPacientes()
    }

    suspend fun insertPaciente(paciente: PacienteEntity) = withContext(Dispatchers.IO) {
        pacienteDao.insertPaciente(paciente)
    }

    suspend fun deletePaciente(paciente: PacienteEntity) = withContext(Dispatchers.IO) {
        pacienteDao.deletePaciente(paciente)
    }
}