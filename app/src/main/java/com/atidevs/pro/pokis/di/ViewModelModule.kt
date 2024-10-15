package com.atidevs.pro.pokis.di

import com.atidevs.pro.pokis.data.repository.ListingRepository
import com.atidevs.pro.pokis.data.repository.ListingRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class ViewModelModule {

    @Binds
    abstract fun bindListingRepository(
        listingRepositoryImpl: ListingRepositoryImpl
    ): ListingRepository

}