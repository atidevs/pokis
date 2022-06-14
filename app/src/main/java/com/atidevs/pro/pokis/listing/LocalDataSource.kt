package com.atidevs.pro.pokis.listing

import com.atidevs.pro.pokis.api.asEntity
import com.atidevs.pro.pokis.common.data.Poki
import com.atidevs.pro.pokis.common.data.PokiDao
import com.atidevs.pro.pokis.common.data.PokiEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val pokiDao: PokiDao) {

    fun getPokemonByName(name: String): Flow<PokiEntity> {
        return pokiDao.findByName(name)
    }

    fun saveAll(pokis: List<Poki>) {
        pokiDao.insertAll(pokis.map { it.asEntity() })
    }
}