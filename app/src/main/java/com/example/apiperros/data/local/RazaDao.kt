package com.example.apiperros.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RazaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)

    suspend fun insertRaza(razaEntity: RazaEntity)

    @Query("SELECT * FROM tabla_razas order by raza desc")
    fun getRazas(): LiveData<RazaEntity>

}