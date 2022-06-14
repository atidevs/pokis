package com.atidevs.pro.pokis.common.data

import android.content.Context
import androidx.room.Room

object DBProvider {
    fun getInstance(context: Context) =
        Room.databaseBuilder(context, PokiDatabase::class.java, "poki_database").build()
}