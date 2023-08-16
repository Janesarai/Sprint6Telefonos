package com.example.sprint6telefonos.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FonoEntity::class, FonoDetalleEntity::class], version =1)

abstract class FonoDataBase: RoomDatabase() {

    abstract fun getFonoDao(): FonoDAO
    companion object {
        @Volatile
        private var INSTANCE: FonoDataBase? = null

        fun getDatabase(context: Context): FonoDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FonoDataBase::class.java,
                    "fonos_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}