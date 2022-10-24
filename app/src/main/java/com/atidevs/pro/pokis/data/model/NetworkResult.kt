package com.atidevs.pro.pokis.data.model

import com.atidevs.pro.pokis.data.model.NetworkResult.Success

sealed class NetworkResult<out R> {

    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Error(val exception: Exception) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }

}

val NetworkResult<*>.succeeded
    get() = this is Success && data != null