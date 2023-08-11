package com.example.apiperros.data.remote

import com.example.apiperros.data.local.RazaDetalleEntity

fun String.toEntity(id:String):RazaDetalleEntity = RazaDetalleEntity(id,this)