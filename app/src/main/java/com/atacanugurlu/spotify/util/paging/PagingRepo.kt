package com.atacanugurlu.spotify.util.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.atacanugurlu.spotify.data.model.response.ResponseData
import com.atacanugurlu.spotify.network.ServiceType
import retrofit2.HttpException
import java.io.IOException

class PagingRepo(
    private val query: String,
    private val serviceType: ServiceType,
    private val pagingDataSource: PagingDataSource
) : PagingSource<Int, ResponseData>() {

    companion object {
        private val inMemoryCache =
            mutableListOf<ResponseData>()
        private val queryCache = mutableListOf<String>()
    }

    private val startPage = 0
    private val limit = 25

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResponseData> {
        val position = params.key ?: startPage
        val apiQuery = query
        return try {

            val oldQuery = queryCache.find {
                apiQuery.equals(it, true)
            }

            if (oldQuery != null && position == startPage) {
                val validatedResults = resultsValidatedAndSorted(apiQuery)
                LoadResult.Page(
                    data = validatedResults,
                    prevKey = null,
                    nextKey = null
                )
            } else {
                val response = when (serviceType) {
                    ServiceType.Artists -> pagingDataSource.fetchArtist(
                        apiQuery,
                        position * limit,
                        limit
                    )
                    ServiceType.Albums -> pagingDataSource.fetchAlbum(
                        apiQuery,
                        position * limit,
                        limit
                    )
                    ServiceType.Tracks -> pagingDataSource.fetchTrack(
                        apiQuery,
                        position * limit,
                        limit
                    )
                }
                val body = response.body()!!
                val results = response.body()!!.data

                queryCache.add(apiQuery)

                val shelled = results.map { ResponseData(query = apiQuery, data = it) }

                inMemoryCache.addAll(
                    shelled
                )

                LoadResult.Page(
                    data = if (position * limit <= body.total) shelled else emptyList(),
                    prevKey = if (position == startPage) null else position - 1,
                    nextKey = if (shelled.isEmpty() || position * limit > body.total) null else position + 1
                )
            }

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    private fun resultsValidatedAndSorted(query: String): List<ResponseData> {
        return inMemoryCache.filter {
            it.query.contains(query, true)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ResponseData>): Int? {
        TODO("Not yet implemented")
    }
}