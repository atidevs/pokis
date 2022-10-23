package com.atidevs.pro.pokis.data.repository

import androidx.paging.PagingData
import com.atidevs.pro.pokis.data.model.Poki
import kotlinx.coroutines.flow.Flow

interface ListingRepository {
    suspend fun getAllPokemons(): Flow<PagingData<Poki>>
    suspend fun getPokemonByName(name: String): Flow<Poki>
}