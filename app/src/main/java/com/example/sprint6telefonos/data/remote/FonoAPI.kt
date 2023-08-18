package com.example.sprint6telefonos.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FonoAPI {

    @GET("products")
    suspend fun getData(): Response<List<Fono>>


    @GET("details/{id}")
    suspend fun getDetalleFono(@Path("id")id:Int): Response<FonoDetalle>
}