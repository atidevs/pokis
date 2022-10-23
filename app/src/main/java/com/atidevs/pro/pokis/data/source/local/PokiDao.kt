package com.atidevs.pro.pokis.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokiDao {

    @Query("SELECT * FROM Pokemon")
    fun getAll(): Flow<List<PokiEntity>>

    @Insert(onConflict = REPLACE)
    fun insertAll(pokis: List<PokiEntity>)

    @Insert(onConflict = REPLACE)
    fun insertAll(vararg poki: PokiEntity)

    @Insert(onConflict = REPLACE)
    fun insert(poki: PokiEntity)

    @Query("SELECT * FROM Pokemon WHERE name LIKE :name")
    fun findByName(name: String): Flow<PokiEntity>
}