package com.atacanugurlu.spotify.data.model.music

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("link")
    val link: String?,

    @SerializedName("share")
    val share: String?,

    @SerializedName("picture")
    val picture: String?,

    @SerializedName("picture_small")
    val pictureSmall: String?,

    @SerializedName("picture_medium")
    val pictureMedium: String?,

    @SerializedName("picture_big")
    val pictureBig: String?,

    @SerializedName("picture_xl")
    val pictureXl: String?,

    @SerializedName("nb_album")
    val nbAlbum: Int?,

    @SerializedName("nb_fan")
    val nbFan: Int?,

    @SerializedName("radio")
    val radio: Boolean?,

    @SerializedName("tracklist")
    val tracklist: String?

) : Parcelable
