package com.atidevs.pro.pokis.listing

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.atidevs.pro.pokis.common.data.Poki
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch

class ListingViewModel(
    application: Application,
    repository: IListingRepository
) : AndroidViewModel(application) {

    var pokiFlow: MutableStateFlow<PagingData<Poki>> = MutableStateFlow(PagingData.empty())

    init {
        viewModelScope.launch {
            val flow = repository.getAllPokemons()
            pokiFlow.emitAll(flow)
        }
    }
}