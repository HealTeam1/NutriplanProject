package com.healtteam.nutriplanproject.domain.model

data class HistorialPlan(
    val planId: Int,
    val fechaAsignacion: String,
    val comentarios: String,
    val estado: String,
    val objetivo: String
)