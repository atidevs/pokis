package com.atidevs.pro.pokis.listing

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.atidevs.pro.pokis.api.asPoki
import com.atidevs.pro.pokis.common.data.Poki
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ListingRepository(
    private val pagingSource: PokiPagingSource,
    private val localCache: LocalDataSource
) : IListingRepository {

    override suspend fun getAllPokemons(): Flow<PagingData<Poki>> {
        return Pager(
            PagingConfig(PokiPagingSource.PAGE_SIZE)
        ) {
            pagingSource
        }.flow
    }

    override suspend fun getPokemonByName(name: String): Flow<Poki> {
        return localCache.getPokemonByName(name).map { it.asPoki() }
    }

}