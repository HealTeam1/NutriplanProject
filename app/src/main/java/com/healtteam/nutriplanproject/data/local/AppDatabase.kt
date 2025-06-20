package com.healtteam.nutriplanproject.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.healtteam.nutriplanproject.data.model.NutricionistaEntity
import com.healtteam.nutriplanproject.data.model.PacienteEntity

@Database(
    entities = [NutricionistaEntity::class, PacienteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun nutricionistaDao(): NutricionistaDao
    abstract fun pacienteDao(): PacienteDao
}