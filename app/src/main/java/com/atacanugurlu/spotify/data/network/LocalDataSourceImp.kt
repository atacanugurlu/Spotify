package com.atacanugurlu.spotify.data.network

import com.atacanugurlu.spotify.core.constants.Constants
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor() : LocalDataSource {
    override fun getApiKey(): String {
        return Constants.API_KEY
    }
}