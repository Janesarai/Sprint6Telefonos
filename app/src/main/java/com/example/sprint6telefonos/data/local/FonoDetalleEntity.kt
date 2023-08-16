package com.example.sprint6telefonos.data.local

import androidx.room.Entity

//revisar si va o no la primary key, si es necesaria

@Entity(tableName = "tabla_detalleFono", primaryKeys =["fonoDescripcion","precioFinal","credito"])
class FonoDetalleEntity (
    val fonoDescripcion: String,
    val precioFinal: Int,
    val credito: Boolean
)