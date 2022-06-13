package com.atidevs.pro.pokis.listing

import android.accounts.NetworkErrorException
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.atidevs.pro.pokis.api.NetworkPoki
import com.atidevs.pro.pokis.api.RestApiService
import com.atidevs.pro.pokis.api.asPoki
import com.atidevs.pro.pokis.utils.getQueryParams
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.awaitResponse
import java.io.IOException

class PokiPagingSource(private val apiService: RestApiService) : PagingSource<Int, Poki>() {

    override fun getRefreshKey(state: PagingState<Int, Poki>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Poki> {
        return withContext(Dispatchers.IO) {
            val nextPageNumber = params.key ?: FIRST_PAGE
            val call = apiService.getPokemons(nextPageNumber, PAGE_SIZE)
            try {
                val response = call.awaitResponse()
                if (response.isSuccessful && response.body() != null) {
                    val body = response.body()
                    val responseItems = body?.results?.map { it.asPoki() }
                    responseItems?.let {
                        LoadResult.Page(
                            responseItems,
                            null,
                            body.next.getQueryParams()[OFFSET_QUERY_PARAM]?.toInt()
                        )
                    } ?: throw NetworkErrorException()
                } else {
                    LoadResult.Error(Throwable(response.errorBody().toString()))
                }
            } catch (io: IOException) {
                LoadResult.Error(io)
            } catch (http: HttpException) {
                LoadResult.Error(http)
            }
        }
    }

    companion object {
        const val PAGE_SIZE = 20
        const val FIRST_PAGE = 20
        const val OFFSET_QUERY_PARAM = "offset"
        const val LIMIT_QUERY_PARAM = "limit"
    }

}
