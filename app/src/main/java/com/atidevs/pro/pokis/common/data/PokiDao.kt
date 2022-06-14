package com.atidevs.pro.pokis.common.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokiDao {

    @Query("SELECT * FROM Pokemon")
    fun getAll(): Flow<List<PokiEntity>>

    @Insert
    fun insertAll(pokis: List<PokiEntity>)

    @Insert
    fun insertAll(vararg poki: PokiEntity)

    @Insert
    fun insert(poki: PokiEntity)

    @Query("SELECT * FROM Pokemon WHERE name LIKE :name")
    fun findByName(name: String): Flow<PokiEntity>
}