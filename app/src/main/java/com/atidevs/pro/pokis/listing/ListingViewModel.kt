package com.atidevs.pro.pokis.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.atidevs.pro.pokis.api.ApiServiceBuilder
import com.atidevs.pro.pokis.api.RestApiService
import kotlinx.coroutines.flow.Flow

class ListingViewModel : ViewModel() {

    var pokiFlow: Flow<PagingData<Poki>>

    init {
        val apiService = ApiServiceBuilder.buildService(RestApiService::class.java)

        pokiFlow = Pager(
            PagingConfig(PokiPagingSource.PAGE_SIZE)
        ) {
            PokiPagingSource(apiService)
        }.flow
            .cachedIn(viewModelScope)
    }

    override fun onCleared() {
        super.onCleared()
    }
}