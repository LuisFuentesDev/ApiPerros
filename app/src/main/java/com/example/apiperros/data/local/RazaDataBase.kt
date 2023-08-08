package com.example.apiperros.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RazaEntity::class], version = 1)
abstract class RazaDataBase : RoomDatabase() {
    abstract fun getRazaDao(): RazaDao

    companion object {
        @Volatile
        private var INSTANCE: RazaDataBase? = null

        fun getDataBase(context: Context): RazaDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RazaDataBase::class.java,
                    "razas_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
