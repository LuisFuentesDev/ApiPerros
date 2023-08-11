package com.example.apiperros.data.remote

import org.junit.Assert.*

import org.junit.Test

class MapperTest {

    @Test
    fun toEntity() {

        //Given dado este valor

        val url = "datoUrl"
        val id = "datoId"

        //When hago esto

        val resultadoTransformacion = url.toEntity(id)

        //Then espero este resultado

        assertEquals(id,resultadoTransformacion.razaDetalle)
        assertEquals(url,resultadoTransformacion.url)
    }

    @Test
    fun toRazaEntity() {
        //Given dado este valor

        val raza = "nombreRaza"

        //When hago esto

        val resultadoTransformacionRaza = raza.toRazaEntity()

        //Then espero este resultado
        assertEquals(raza, resultadoTransformacionRaza.raza)
    }
}