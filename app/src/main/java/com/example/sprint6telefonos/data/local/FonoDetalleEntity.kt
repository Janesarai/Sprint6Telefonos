package com.example.sprint6telefonos.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

//revisar si va o no la primary key, si es necesaria

@Entity(tableName = "tabla_detalleFono")
class FonoDetalleEntity (
    @PrimaryKey val id: Int,
    val nombre: String,
    val precio: Int,
    val imagen: String,
    val fonoDescripcion: String,
    val precioFinal: Int,
    val credito: Boolean
)