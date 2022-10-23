package com.atidevs.pro.pokis.common

import android.content.Context
import androidx.room.Room
import com.atidevs.pro.pokis.data.source.remote.ApiServiceBuilder
import com.atidevs.pro.pokis.api.RetrofitApiService
import com.atidevs.pro.pokis.data.source.local.PokiDatabase
import com.atidevs.pro.pokis.data.repository.ListingRepository
import com.atidevs.pro.pokis.data.repository.ListingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideRetrofitService(): RetrofitApiService =
        ApiServiceBuilder.buildService(RetrofitApiService::class.java)

    @Provides
    fun provideRoomDB(@ApplicationContext context: Context): PokiDatabase =
        Room.databaseBuilder(context, PokiDatabase::class.java, "poki_database").build()

}

@InstallIn(SingletonComponent::class)
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindListingRepository(
        listingRepositoryImpl: ListingRepositoryImpl
    ): ListingRepository

}