package com.example.apiperros.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.apiperros.data.local.RazaDao
import com.example.apiperros.data.local.RazaDetalleEntity
import com.example.apiperros.data.local.RazaEntity
import com.example.apiperros.data.remote.RazaApi

class Repositorio(private val razaApi: RazaApi, private val razaDao: RazaDao) {

    fun obtenerRazaEntity(): LiveData<List<RazaEntity>> = razaDao.getRazas()
    suspend fun getRazas() {
        val response = razaApi.getData()
        if (response.isSuccessful) {
            val message = response.body()!!.message
            val keys = message.keys
            keys.forEach {
                val razaEntity = RazaEntity(it)
                razaDao.insertRaza(razaEntity)
            }

        } else {
            Log.e("repositorio", response.errorBody().toString())
        }
    }

    suspend fun getDetallePerro(id: String) {
        val response = razaApi.getDetallePerro(id)
        if (response.isSuccessful) {
            response.body()!!.message.forEach {
                val razaDetalleEntity = RazaDetalleEntity(id, it)
                razaDao.insertDetallePerro(razaDetalleEntity)
            }

        } else {
            Log.e("repositorio", response.errorBody().toString())
        }
    }
}
