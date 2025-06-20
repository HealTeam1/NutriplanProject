package com.healtteam.nutriplanproject.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.healtteam.nutriplanproject.domain.model.Nutricionista
import com.healtteam.nutriplanproject.domain.model.Direccion
import com.healtteam.nutriplanproject.domain.model.RedesSociales
import com.healtteam.nutriplanproject.domain.model.Paciente
import com.healtteam.nutriplanproject.domain.model.PlanAlimenticio


@Entity(tableName = "nutricionistas")
data class NutricionistaEntity(
    @PrimaryKey val id: Int,
    val usuario: String,
    val especialidad: String,
    val correo: String,
    val telefono: String,
    val numeroCertificado: String,
    val direccion: String,
    val redesSociales: String,
    val pacientes: String,
    val planesPersonalizados: String
)