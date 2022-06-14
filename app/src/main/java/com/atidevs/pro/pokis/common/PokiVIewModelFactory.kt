package com.atidevs.pro.pokis.common

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.atidevs.pro.pokis.listing.ListingViewModel

class PokiVIewModelFactory(
    private val application: Application
) :
    ViewModelProvider.AndroidViewModelFactory(application) {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListingViewModel::class.java)) {
            return ListingViewModel(application) as T
        } else throw ClassNotFoundException("Unknown ViewModel class!")
    }
}