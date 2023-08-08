package com.example.apiperros.data

import com.example.apiperros.data.local.RazaDao
import com.example.apiperros.data.local.RazaEntity
import com.example.apiperros.data.remote.RazaApi

class Repositorio(private val razaApi: RazaApi, private val razaDao: RazaDao) {

    suspend fun getRazas() {
        val response = razaApi.getData()
        if (response.isSuccessful) {
            val message = response.body()!!.message
            val keys = message.keys
            keys.forEach {
                val razaEntity = RazaEntity(it)
                razaDao.insertRaza(razaEntity)
            }

        }
    }
}
