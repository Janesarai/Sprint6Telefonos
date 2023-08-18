package com.example.sprint6telefonos.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FonoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFono(fonoEntity: FonoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFono(fonoEntity: List <FonoEntity>)

    @Query("Select * from tabla_fono order by id asc")
    fun getFonos(): LiveData<List<FonoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetalleFono(fonoDetalleEntity: FonoDetalleEntity)

    @Query("Select * from tabla_detalleFono where id = :id")
    fun getFonoDetalle(id:Int): LiveData<FonoDetalleEntity>
}