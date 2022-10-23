package com.atidevs.pro.pokis.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.atidevs.pro.pokis.common.data.Poki
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val repository: ListingRepository
) : ViewModel() {

    var pokiFlow: MutableStateFlow<PagingData<Poki>> = MutableStateFlow(PagingData.empty())

    init {
        viewModelScope.launch {
            val flow = repository.getAllPokemons()
            pokiFlow.emitAll(flow)
        }
    }
}