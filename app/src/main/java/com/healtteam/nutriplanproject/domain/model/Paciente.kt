package com.healtteam.nutriplanproject.domain.model

data class Paciente(
    val id: Int,
    val nombre: String,
    val apellido: String,
    val fechaNacimiento: String,
    val genero: String,
    val alergias: List<String>,
    val preferenciasAlimenticias: List<String>,
    val seguimiento: Seguimiento,
    val planAsignadoActual: Int,
    val historialPlanes: List<HistorialPlan>
)