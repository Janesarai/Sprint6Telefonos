package com.example.sprint6telefonos.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FonoRetrofit {

    //revisar si el / va o no o va en la api

    companion object {
        private  const val URL_BASE = "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"


        fun getRetrofitFono() : FonoAPI {
            val mRetrofit = Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return mRetrofit.create(FonoAPI::class.java)

        }
    }
}