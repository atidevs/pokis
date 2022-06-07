package com.atidevs.pro.pokis.api

import com.atidevs.pro.pokis.models.PokiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApiService {

    @GET("/api/v2/pokemon/")
    fun getPokemons(@Query("offset") offset: Int, @Query("limit") pageSize: Int): Call<PokiResponse>
}