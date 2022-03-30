package com.atacanugurlu.spotify.data.entities

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseModel<T>(

    @SerializedName("total")
    val total: Int,

    @SerializedName("data")
    val data: List<T>

)
