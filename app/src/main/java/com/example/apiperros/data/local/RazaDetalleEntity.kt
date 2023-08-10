package com.example.apiperros.data.local

import androidx.room.Entity


@Entity(tableName = "tabla_razasDetalle", primaryKeys = ["razaDetalle", "url"])
class RazaDetalleEntity(val razaDetalle: String, val url: String)
