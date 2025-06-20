package com.healtteam.nutriplanproject.domain.model

data class Seguimiento(
    val pesoKg: Float,
    val alturaCm: Int,
    val imc: Float,
    val fechaUltimoControl: String
)