package com.atidevs.pro.pokis.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.atidevs.pro.pokis.data.model.Poki
import com.atidevs.pro.pokis.data.repository.ListingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListingViewModel @Inject constructor(
    private val repository: ListingRepository
) : ViewModel() {

    private val _pokiFlow: MutableStateFlow<PagingData<Poki>> = MutableStateFlow(PagingData.empty())
    val pokiFlow : StateFlow<PagingData<Poki>> = _pokiFlow

    init {
        viewModelScope.launch {
            val flow = repository.getAllPokemons()
            _pokiFlow.emitAll(flow)
        }
    }
}