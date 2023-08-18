package com.example.sprint6telefonos.vistas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sprint6telefonos.data.Repositorio
import com.example.sprint6telefonos.data.local.FonoDataBase
import com.example.sprint6telefonos.data.remote.FonoRetrofit
import kotlinx.coroutines.launch

class FonoVM( application: Application): AndroidViewModel(application) {
    private val repositorio: Repositorio

init {
    val fonoApi = FonoRetrofit.getRetrofitFono()
    val fonoDataBase = FonoDataBase.getDatabase(application).getFonoDao()
    repositorio = Repositorio(fonoApi,fonoDataBase)
}

    fun fonoLiveData()= repositorio.obtenerFonosEntity()

// falta detalle
    fun detalleLiveData(id:Int)= repositorio.obtenerFonosDetalle(id)

    fun getTodosFonos()= viewModelScope.launch {
        repositorio.getFonos()
    }

    fun getDetallesFono(id:Int) = viewModelScope.launch {
        repositorio.getDetalleFono(id)
    }
}