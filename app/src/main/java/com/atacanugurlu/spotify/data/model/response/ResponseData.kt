package com.atacanugurlu.spotify.data.model.response

import androidx.annotation.Keep

@Keep
data class ResponseData(
    val query: String,
    val data: Any
)
