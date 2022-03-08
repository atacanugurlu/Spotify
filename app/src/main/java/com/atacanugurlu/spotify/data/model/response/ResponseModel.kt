package com.atacanugurlu.spotify.data.model.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseModel<T>(

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val items: List<T>,

    @SerializedName("total_pages")
    val pages: Int

)