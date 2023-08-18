package com.example.sprint6telefonos.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sprint6telefonos.data.local.FonoDAO
import com.example.sprint6telefonos.data.local.FonoDetalleEntity
import com.example.sprint6telefonos.data.local.FonoEntity
import com.example.sprint6telefonos.data.remote.Fono
import com.example.sprint6telefonos.data.remote.FonoAPI
import com.example.sprint6telefonos.data.remote.FonoDetalle

class Repositorio (private val fonoAPI: FonoAPI, private val fonoDAO: FonoDAO) {

    fun obtenerFonosEntity(): LiveData<List<FonoEntity>> = fonoDAO.getFonos()

    fun obtenerFonosDetalle(id: Int): LiveData<FonoDetalleEntity> = fonoDAO.getFonoDetalle(id)

    suspend fun getFonos() {
        try {
            val response = fonoAPI.getData()// llegan los datos
            if (response.isSuccessful) { //llegaron los datos?
                val resp = response.body()
                resp?.let { fono ->
                        val fonoEntity = fono.map{it.toEntity()}
                    Log.e("fonoEntity.size",fonoEntity.size.toString() )
                        fonoDAO.insertFono(fonoEntity)
                }
            }
        } catch (exeption: Exception) {
            Log.e("catch", "")
        }
    }

    suspend fun getDetalleFono(id: Int) {
        // try para que no se caiga sin internet
        try {
            val response = fonoAPI.getDetalleFono(id)// llegan los datos
            if (response.isSuccessful) {
                val resp = response.body()
                if(resp!= null){
                    val fonoDetalleEntity = resp.toEntity()
                    fonoDAO.insertDetalleFono(fonoDetalleEntity)
                }
            }

        } catch (exeption: Exception) {
            Log.e("catch", "")
        }
    }
}
fun Fono.toEntity(): FonoEntity = FonoEntity(this.id, this.name, this.price, this.image)
fun FonoDetalle.toEntity(): FonoDetalleEntity = FonoDetalleEntity(this.id, this.name, this.price, this.image,this.description, this.lastPrice, this.credit)