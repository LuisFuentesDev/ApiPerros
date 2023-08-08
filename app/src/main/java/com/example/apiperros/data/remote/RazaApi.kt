package com.example.apiperros.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface RazaApi {
    @GET("breeds/list/all")
    suspend fun getData():Response<RazaPerritos>
}