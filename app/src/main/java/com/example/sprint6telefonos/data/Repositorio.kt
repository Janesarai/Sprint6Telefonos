package com.example.sprint6telefonos.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sprint6telefonos.data.local.FonoDAO
import com.example.sprint6telefonos.data.local.FonoDetalleEntity
import com.example.sprint6telefonos.data.local.FonoEntity
import com.example.sprint6telefonos.data.remote.Fono
import com.example.sprint6telefonos.data.remote.FonoAPI

class Repositorio (private val fonoAPI: FonoAPI, private val fonoDAO: FonoDAO){

    fun obtenerFonosEntity(): LiveData<List<FonoEntity>> = fonoDAO.getFonos()

    fun obtenerFonosDetalle(id: String): LiveData<List<FonoDetalleEntity>> = fonoDAO.getFonoDetalle(id)

    suspend fun getFonos() {
        try {
            val response = fonoAPI.getData()// llegan los datos
            if (response.isSuccessful) { //llegaron los datos?
                val resp = response.body()
                resp?.let { fono->
                    val fonoEntity =  fono.toEntity()
                    fonoDAO.insertFono(fonoEntity)
                }
            }
        } catch (exeption: Exception) {
            Log.e("catch", "")
        }
    }
}
fun Fono.toEntity(): FonoEntity = FonoEntity(this.id, this.name, this.price, this.image)