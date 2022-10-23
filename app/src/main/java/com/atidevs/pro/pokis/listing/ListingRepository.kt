package com.atidevs.pro.pokis.listing

import androidx.paging.PagingData
import com.atidevs.pro.pokis.common.data.Poki
import kotlinx.coroutines.flow.Flow

interface ListingRepository {
    suspend fun getAllPokemons(): Flow<PagingData<Poki>>
    suspend fun getPokemonByName(name: String): Flow<Poki>
}