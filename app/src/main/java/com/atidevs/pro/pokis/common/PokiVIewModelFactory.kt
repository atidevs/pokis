package com.atidevs.pro.pokis.common

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atidevs.pro.pokis.listing.IListingRepository
import com.atidevs.pro.pokis.listing.ListingViewModel

class PokiVIewModelFactory(
    private val application: Application,
    private val repository: IListingRepository
) :
    ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListingViewModel::class.java)) {
            return ListingViewModel(application, repository) as T
        } else throw ClassNotFoundException("Unknown ViewModel class!")
    }
}