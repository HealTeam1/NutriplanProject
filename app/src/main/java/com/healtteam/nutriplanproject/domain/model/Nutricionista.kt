package com.healtteam.nutriplanproject.domain.model

data class Nutricionista(
    val id: Int,
    val usuario: String,
    val numeroCertificado: String,
    val especialidad: String,
    val correo: String,
    val telefono: String,
    val direccion: Direccion,
    val redesSociales: RedesSociales,
    val pacientes: List<Paciente>,
    val planesPersonalizados: List<PlanAlimenticio>
)