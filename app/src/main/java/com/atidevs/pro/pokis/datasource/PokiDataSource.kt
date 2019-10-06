package com.atidevs.pro.pokis.datasource

import androidx.paging.PageKeyedDataSource
import com.atidevs.pro.pokis.api.ApiServiceBuilder
import com.atidevs.pro.pokis.api.RestApiService
import com.atidevs.pro.pokis.models.Poki
import com.atidevs.pro.pokis.models.PokiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokiDataSource : PageKeyedDataSource<Int, Poki>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Poki>
    ) {
        val service = ApiServiceBuilder.buildService(RestApiService::class.java)
        val call = service.getPokemons(FIRST_PAGE, PAGE_SIZE)

        call.enqueue(object : Callback<PokiResponse> {
            override fun onResponse(call: Call<PokiResponse>, response: Response<PokiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.pokis
                    responseItems?.let {
                        callback.run {
                            onResult(
                                responseItems,
                                null,
                                FIRST_PAGE + PAGE_SIZE
                            )
                        }
                    }
                }
            }

            override fun onFailure(call: Call<PokiResponse>, t: Throwable) {
            }
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Poki>) {
        val service = ApiServiceBuilder.buildService(RestApiService::class.java)
        val call = service.getPokemons(params.key, PAGE_SIZE)
        call.enqueue(object : Callback<PokiResponse> {
            override fun onResponse(call: Call<PokiResponse>, response: Response<PokiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.pokis
                    val key = params.key + PAGE_SIZE
                    responseItems?.let {
                        callback.run {
                            onResult(
                                responseItems,
                                key
                            )
                        }
                    }
                }
            }

            override fun onFailure(call: Call<PokiResponse>, t: Throwable) {
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Poki>) {
        val service = ApiServiceBuilder.buildService(RestApiService::class.java)
        val call = service.getPokemons(params.key, PAGE_SIZE)
        call.enqueue(object : Callback<PokiResponse> {
            override fun onResponse(call: Call<PokiResponse>, response: Response<PokiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.pokis
                    val key = if (params.key > 20) params.key - PAGE_SIZE else 0
                    responseItems?.let {
                        callback.run {
                            onResult(
                                responseItems,
                                key
                            )
                        }
                    }
                }
            }

            override fun onFailure(call: Call<PokiResponse>, t: Throwable) {
            }
        })
    }

    companion object {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 20
    }

}
