package com.example.sprint6telefonos.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface FonoAPI {

    @GET("products")
    suspend fun getData(): Response<List<Fono>>


    @GET("/Himuravidal/FakeAPIdata/details/{id}")
    suspend fun getDetalleFono(): Response<FonoDetalle>
}