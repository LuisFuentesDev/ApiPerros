package com.example.apiperros.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_razas")
data class RazaEntity(@PrimaryKey val raza: String)




