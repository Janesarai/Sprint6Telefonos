package com.example.sprint6telefonos.data

import com.example.sprint6telefonos.data.local.FonoDetalleEntity
import com.example.sprint6telefonos.data.local.FonoEntity
import com.example.sprint6telefonos.data.remote.Fono
import com.example.sprint6telefonos.data.remote.FonoDetalle

fun Fono.toEntity(): FonoEntity = FonoEntity(this.id, this.name, this.price, this.image)
fun FonoDetalle.toEntity(): FonoDetalleEntity = FonoDetalleEntity(this.id, this.name, this.price, this.image,this.description, this.lastPrice, this.credit)