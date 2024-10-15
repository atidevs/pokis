package com.atidevs.pro.pokis.api

import com.atidevs.pro.pokis.data.model.NetworkPagedResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {

    @GET("/api/v2/pokemon/")
    suspend fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") pageSize: Int
    ): Response<NetworkPagedResponse>
}