package com.atidevs.pro.pokis.listing

import com.atidevs.pro.pokis.api.asEntity
import com.atidevs.pro.pokis.common.data.Poki
import com.atidevs.pro.pokis.common.data.PokiDatabase
import com.atidevs.pro.pokis.common.data.PokiEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val pokiDb: PokiDatabase) {

    fun getPokemonByName(name: String): Flow<PokiEntity> {
        return pokiDb.pokiDao().findByName(name)
    }

    fun saveAll(pokis: List<Poki>) {
        pokiDb.pokiDao().insertAll(pokis.map { it.asEntity() })
    }
}