package com.example.sprint6telefonos.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface FonoAPI {

    @GET("/Himuravidal/FakeAPIdata/products/")
    suspend fun getData(): Response<Fono>

    // revisar si va con int o no el id (o si es necesaario el path)

    @GET("/Himuravidal/FakeAPIdata/details/{id}")
    suspend fun getDetalleFono(): Response<FonoDetalle>
}