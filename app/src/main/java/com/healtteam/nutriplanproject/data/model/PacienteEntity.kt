package com.healtteam.nutriplanproject.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pacientes")
data class PacienteEntity(
    @PrimaryKey val id: Int,
    val nombre: String,
    val edad: Int,
    val correo: String,
    val detalles: String
)