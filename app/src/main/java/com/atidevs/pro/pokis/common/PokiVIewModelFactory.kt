package com.atidevs.pro.pokis.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atidevs.pro.pokis.listing.ListingRepository
import com.atidevs.pro.pokis.listing.ListingViewModel
import javax.inject.Inject

class PokiVIewModelFactory @Inject constructor(
    private val repository: ListingRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListingViewModel::class.java)) {
            return ListingViewModel(repository) as T
        } else throw ClassNotFoundException("Unknown ViewModel class!")
    }
}