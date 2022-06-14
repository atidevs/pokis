package com.atidevs.pro.pokis.common.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Pokemon")
data class PokiEntity(
    @PrimaryKey
    val name: String,
    val url: String
)
