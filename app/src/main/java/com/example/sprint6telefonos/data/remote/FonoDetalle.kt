package com.example.sprint6telefonos.data.remote

data class FonoDetalle (
    // revisar si la otra info de detalle id y demas van o no aqui
    val id: Int,
    val name: String,
    val price: Int,
    val image: String,
    val description: String,
    val lastPrice: Int,
    val credit: Boolean
)