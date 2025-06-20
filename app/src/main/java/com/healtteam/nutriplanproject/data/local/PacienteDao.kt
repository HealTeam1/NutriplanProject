package com.healtteam.nutriplanproject.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import com.healtteam.nutriplanproject.data.model.PacienteEntity

@Dao
interface PacienteDao {

    @Insert
    suspend fun insertPaciente(paciente: PacienteEntity)

    @Update
    suspend fun updatePaciente(paciente: PacienteEntity)

    @Delete
    suspend fun deletePaciente(paciente: PacienteEntity)

    @Query("SELECT * FROM pacientes WHERE id = :id")
    suspend fun getPacienteById(id: Int): PacienteEntity?

    @Query("SELECT * FROM pacientes")
    suspend fun getAllPacientes(): List<PacienteEntity>
}