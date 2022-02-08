package com.atacanugurlu.spotify.util.paging

import androidx.paging.PagingData
import com.atacanugurlu.spotify.data.model.response.ResponseData
import com.atacanugurlu.spotify.network.ServiceType
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun fetch(query: String, serviceType: ServiceType): Flow<PagingData<ResponseData>>
}