package com.atacanugurlu.spotify.network

import com.atacanugurlu.spotify.util.constants.Constants
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.*
import javax.inject.Inject

class HttpInterceptor @Inject constructor(
    private val localDataSource: LocalDataSource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = localDataSource.getApiKey()

        val request = chain.request()
        val requestBuilder = request.newBuilder()

        if (request.header("No-Authentication") == null) {
            requestBuilder.addHeader("access_token", token)
        } else {
            requestBuilder.removeHeader("No-Authentication")
        }

        if (request.header("No-Locality") == null) {
            val url = chain.request().url.newBuilder()
                .addQueryParameter("locale", Locale.getDefault().language)
                .build()
            requestBuilder.url(url)
        } else {
            requestBuilder.removeHeader("No-Locality")
        }
        val newRequest = requestBuilder.build()
        return try {
            chain.proceed(newRequest)
        } catch (e: Exception) {
            throw IOException(e.message)
        }
    }
}

interface LocalDataSource {
    fun getApiKey(): String
}

class LocalDataSourceImp @Inject constructor() : LocalDataSource {
    override fun getApiKey(): String {
        return Constants.API_KEY
    }

}