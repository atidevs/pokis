package com.atidevs.pro.pokis.di

import android.content.Context
import androidx.room.Room
import com.atidevs.pro.pokis.api.RetrofitApiService
import com.atidevs.pro.pokis.data.source.local.PokiDatabase
import com.atidevs.pro.pokis.data.source.remote.ApiServiceBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitService(): RetrofitApiService =
        ApiServiceBuilder.buildService(RetrofitApiService::class.java)

    @Provides
    @Singleton
    fun provideRoomDB(@ApplicationContext context: Context): PokiDatabase =
        Room.databaseBuilder(context, PokiDatabase::class.java, "poki_database").build()

}