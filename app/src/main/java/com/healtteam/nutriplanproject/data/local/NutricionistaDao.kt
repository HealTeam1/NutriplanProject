package com.healtteam.nutriplanproject.data.local

import androidx.room.*
import com.healtteam.nutriplanproject.data.model.NutricionistaEntity

@Dao
interface NutricionistaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNutricionista(nutricionista: NutricionistaEntity)

    @Update
    suspend fun updateNutricionista(nutricionista: NutricionistaEntity)

    @Delete
    suspend fun deleteNutricionista(nutricionista: NutricionistaEntity)

    @Query("SELECT * FROM nutricionistas WHERE id = :id")
    suspend fun getNutricionistaById(id: Int): NutricionistaEntity?

    @Query("SELECT * FROM nutricionistas")
    suspend fun getAllNutricionistas(): List<NutricionistaEntity>
}