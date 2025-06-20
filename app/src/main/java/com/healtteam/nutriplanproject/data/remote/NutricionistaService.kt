package com.healtteam.nutriplanproject.data.remote

import com.healtteam.nutriplanproject.data.model.NutricionistaResponse
import retrofit2.http.GET

interface NutricionistaService {

    @GET("nutricionistas")
    suspend fun getNutricionistas(): List<NutricionistaResponse>
}