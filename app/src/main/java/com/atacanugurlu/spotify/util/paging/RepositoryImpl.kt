package com.atacanugurlu.spotify.util.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.atacanugurlu.spotify.data.model.response.ResponseData
import com.atacanugurlu.spotify.network.ServiceType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val pagingDataSource: PagingDataSource
): Repository {
    override fun fetch(query: String, serviceType: ServiceType): Flow<PagingData<ResponseData>> {
        return Pager(
            config = PagingConfig(
                pageSize = 25,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                PagingRepo(
                    query,
                    serviceType,
                    pagingDataSource
                )
            }
        ).flow
    }
}