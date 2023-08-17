package com.example.sprint6telefonos.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabla_fono")
data class FonoEntity (
    @PrimaryKey val id: String,
    val nombre: String,
    val precio: Int,
    val imagen: String
)