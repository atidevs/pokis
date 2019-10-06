package com.atidevs.pro.pokis.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.atidevs.pro.pokis.models.Poki

class PokiDataSourceFactory : DataSource.Factory<Int, Poki>() {

    val pokiLiveDataSource = MutableLiveData<PokiDataSource>()

    override fun create(): DataSource<Int, Poki> {
        val pokiDataSource = PokiDataSource()
        pokiLiveDataSource.postValue(pokiDataSource)
        return pokiDataSource
    }
}