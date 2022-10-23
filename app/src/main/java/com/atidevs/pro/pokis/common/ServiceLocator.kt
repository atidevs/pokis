package com.atidevs.pro.pokis.common

import android.content.Context
import androidx.room.Room
import com.atidevs.pro.pokis.api.ApiServiceBuilder
import com.atidevs.pro.pokis.api.RetrofitApiService
import com.atidevs.pro.pokis.common.data.PokiDao
import com.atidevs.pro.pokis.common.data.PokiDatabase
import com.atidevs.pro.pokis.listing.ListingRepository
import com.atidevs.pro.pokis.listing.ListingRepositoryImpl
import com.atidevs.pro.pokis.listing.LocalDataSource
import com.atidevs.pro.pokis.listing.PokiPagingSource

object ServiceLocator {
    fun provideListingRepository(context: Context): ListingRepository {
        return ListingRepositoryImpl(
            providePokiPagingSource(context).value,
            provideLocalDataSource(context).value
        )
    }

    private fun provideLocalDataSource(context: Context): Lazy<LocalDataSource> = lazy {
        LocalDataSource(provideRoomDB(context).value)
    }

    private fun providePokiPagingSource(context: Context): Lazy<PokiPagingSource> = lazy {
        PokiPagingSource(providePokiApiService().value, provideLocalDataSource(context).value)
    }

    private fun providePokiApiService(): Lazy<RetrofitApiService> = lazy {
        ApiServiceBuilder.buildService(RetrofitApiService::class.java)
    }

    private fun provideRoomDB(context: Context) = lazy {
        Room.databaseBuilder(context, PokiDatabase::class.java, "poki_database").build()
    }
}