package com.atacanugurlu.spotify.util.converter

import com.google.gson.annotations.SerializedName

sealed class NetworkResponse<out T> {
    data class Success<out T>(@SerializedName("data") val data: T): NetworkResponse<T>()
    data class GenericError(
        @SerializedName("error") val error: Error
    ): NetworkResponse<Nothing>()
    object NetworkError: NetworkResponse<Nothing>()
}