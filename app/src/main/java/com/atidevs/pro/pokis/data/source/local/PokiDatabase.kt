package com.atidevs.pro.pokis.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [PokiEntity::class],
    version = 1
)
abstract class PokiDatabase : RoomDatabase() {
    abstract fun pokiDao(): PokiDao
}