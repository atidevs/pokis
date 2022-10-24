package com.atidevs.pro.pokis.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.atidevs.pro.pokis.api.asPoki
import com.atidevs.pro.pokis.data.model.Poki
import com.atidevs.pro.pokis.data.source.local.PokiLocalDataSource
import com.atidevs.pro.pokis.data.source.remote.PokiRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ListingRepositoryImpl @Inject constructor(
    private val pagingSource: PokiRemoteDataSource,
    private val localCache: PokiLocalDataSource
) : ListingRepository {

    override suspend fun getAllPokemons(): Flow<PagingData<Poki>> {
        return Pager(
            PagingConfig(PokiRemoteDataSource.PAGE_SIZE)
        ) {
            pagingSource
        }.flow
    }

    override suspend fun getPokemonByName(name: String): Flow<Poki> {
        return localCache.getPokemonByName(name).map { it.asPoki() }
    }

}