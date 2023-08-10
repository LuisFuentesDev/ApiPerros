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

    @Query("SELECT * FROM tabla_razas order by raza asc")
    fun getRazas(): LiveData<List<RazaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetallePerro(razaDetalleEntity: RazaDetalleEntity)

    @Query("SELECT * FROM tabla_razas_detalle where razaDetalle like :id ")
    fun getRazaDetalle(id: String): LiveData<List<RazaDetalleEntity>>


}