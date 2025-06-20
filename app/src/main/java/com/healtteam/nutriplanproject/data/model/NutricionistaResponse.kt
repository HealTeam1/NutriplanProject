package com.healtteam.nutriplanproject.data.model


import com.healtteam.nutriplan.domain.model.Nutricionista

data class NutricionistaResponse(
    val id: Int?,
    val usuario: String?,
    val contrasena: String?,
    val numero_certificado: String?,
    val especialidad: String?,
    val correo: String?,
    val telefono: String?,
    val direccion: DireccionResponse?,
    val redes_sociales: RedesSocialesResponse?,
    val pacientes: List<PacienteResponse>?,
    val planes_personalizados: List<PlanPersonalizadoResponse>?
)

data class DireccionResponse(
    val ciudad: String?,
    val pais: String?
)

data class RedesSocialesResponse(
    val instagram: String?,
    val linkedin: String?
)

data class PacienteResponse(
    val id: Int?,
    val nombre: String?,
    val apellido: String?,
    val fecha_nacimiento: String?,
    val genero: String?,
    val alergias: List<String>?,
    val preferencias_alimenticias: List<String>?,
    val seguimiento: SeguimientoResponse?,
    val plan_asignado_actual: Int?,
    val historial_planes: List<HistorialPlanResponse>?
)

data class SeguimientoResponse(
    val peso_kg: Int?,
    val altura_cm: Int?,
    val imc: Double?,
    val fecha_ultimo_control: String?
)

data class HistorialPlanResponse(
    val plan_id: Int?,
    val fecha_asignacion: String?,
    val comentarios: String?,
    val estado: String?,
    val objetivo: String?
)

data class PlanPersonalizadoResponse(
    val id: Int?,
    val nombre: String?,
    val comidas: ComidasResponse?
)

data class ComidasResponse(
    val desayuno: String?,
    val almuerzo: String?,
    val cena: String?
)