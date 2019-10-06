package com.atidevs.pro.pokis.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.atidevs.pro.pokis.datasource.PokiDataSource
import com.atidevs.pro.pokis.datasource.PokiDataSourceFactory
import com.atidevs.pro.pokis.models.Poki

class PokiViewModel : ViewModel() {

    var pokiPagedList: LiveData<PagedList<Poki>>

    private var liveDataSource: LiveData<PokiDataSource>

    init {
        val itemDataSourceFactory = PokiDataSourceFactory()
        liveDataSource = itemDataSourceFactory.pokiLiveDataSource

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(PokiDataSource.PAGE_SIZE)
            .build()

        pokiPagedList = LivePagedListBuilder(itemDataSourceFactory, config)
            .build()
    }
}