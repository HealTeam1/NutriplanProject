package com.healtteam.nutriplanproject.domain.model

data class PlanAlimenticio(
    val id: Int,
    val nombre: String,
    val comidas: Comidas
)