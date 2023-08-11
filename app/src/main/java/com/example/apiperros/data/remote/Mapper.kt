package com.example.apiperros.data.remote

import com.example.apiperros.data.local.RazaDetalleEntity
import com.example.apiperros.data.local.RazaEntity

fun String.toEntity(id:String):RazaDetalleEntity = RazaDetalleEntity(id,this)

fun String.toRazaEntity(): RazaEntity = RazaEntity(this)