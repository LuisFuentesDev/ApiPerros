package com.example.apiperros.data.local

import androidx.room.Entity


@Entity(tableName = "tabla_razas_detalle", primaryKeys = ["razaDetalle", "url"])
class RazaDetalleEntity(val razaDetalle: String, val url: String)
