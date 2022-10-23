package com.atidevs.pro.pokis.data.source.local

import com.atidevs.pro.pokis.api.asEntity
import com.atidevs.pro.pokis.data.model.Poki
import com.atidevs.pro.pokis.data.source.PokiDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val pokiDb: PokiDatabase): PokiDataSource {

    fun getPokemonByName(name: String): Flow<PokiEntity> {
        return pokiDb.pokiDao().findByName(name)
    }

    fun saveAll(pokis: List<Poki>) {
        pokiDb.pokiDao().insertAll(pokis.map { it.asEntity() })
    }
}