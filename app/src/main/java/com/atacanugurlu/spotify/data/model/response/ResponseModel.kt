package com.atacanugurlu.spotify.data.model.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseModel<T>(

    @SerializedName("total")
    val total: Int,

    @SerializedName("data")
    val data: List<T>

)
