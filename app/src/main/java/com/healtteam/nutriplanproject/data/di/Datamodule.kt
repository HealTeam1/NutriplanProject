package com.healtteam.nutriplanproject.data.di


import androidx.room.Room
import com.healtteam.nutriplanproject.NutriPlanApplication
import com.healtteam.nutriplanproject.data.local.AppDatabase
import com.healtteam.nutriplanproject.data.local.NutricionistaDao
import com.healtteam.nutriplanproject.data.local.PacienteDao
import com.healtteam.nutriplanproject.data.remote.NutricionistaService
import com.healtteam.nutriplanproject.data.repository.NutricionistaRepository
import com.healtteam.nutriplanproject.data.repository.PacienteRepository
import com.healtteam.nutriplanproject.data.remote.ApiConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    fun getNutricionistaRepository(): NutricionistaRepository {
        return NutricionistaRepository(getNutricionistaDao())
    }

    fun getPacienteRepository(): PacienteRepository {
        return PacienteRepository(getPacienteDao())
    }

    fun getNutricionistaService(): NutricionistaService {
        return getRetrofit().create(NutricionistaService::class.java)
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getNutricionistaDao(): NutricionistaDao {
        return getAppDatabase().nutricionistaDao()
    }

    fun getPacienteDao(): PacienteDao {
        return getAppDatabase().pacienteDao()
    }

    fun getAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            NutriPlanApplication.instance.applicationContext,
            AppDatabase::class.java, "nutriplan-db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}