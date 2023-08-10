package com.example.apiperros.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface RazaApi {
    @GET("breeds/list/all")
    suspend fun getData():Response<RazaPerritos>

    @GET("breed/{id}/images")
    suspend fun getDetallePerro(@Path("id") id:String):Response<PerroDetalle>
}