package com.atacanugurlu.spotify.data.entities

import androidx.annotation.Keep

@Keep
data class ResponseData(
    val query: String,
    val data: Any
)
