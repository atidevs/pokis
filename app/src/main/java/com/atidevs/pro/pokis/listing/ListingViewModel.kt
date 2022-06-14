package com.atidevs.pro.pokis.listing

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.atidevs.pro.pokis.api.ApiServiceBuilder
import com.atidevs.pro.pokis.api.RestApiService
import com.atidevs.pro.pokis.common.data.DBProvider
import com.atidevs.pro.pokis.common.data.Poki
import kotlinx.coroutines.flow.Flow

class ListingViewModel(application: Application) : AndroidViewModel(application) {

    var pokiFlow: Flow<PagingData<Poki>>

    init {
        val apiService = ApiServiceBuilder.buildService(RestApiService::class.java)
        val db = DBProvider.getInstance(application)

        pokiFlow = Pager(
            PagingConfig(PokiPagingSource.PAGE_SIZE)
        ) {
            PokiPagingSource(apiService)
        }.flow
            .cachedIn(viewModelScope)
    }
}