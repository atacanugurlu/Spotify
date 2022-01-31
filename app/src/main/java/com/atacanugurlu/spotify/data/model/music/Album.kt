package com.atacanugurlu.spotify.data.model.music

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("upc")
    val upc: String?,

    @SerializedName("link")
    val link: String?,

    @SerializedName("share")
    val share: String?,

    @SerializedName("cover")
    val cover: String?,

    @SerializedName("cover_small")
    val coverSmall: String?,

    @SerializedName("cover_medium")
    val coverMedium: String?,

    @SerializedName("cover_big")
    val coverBig: String?,

    @SerializedName("cover_xl")
    val coverXl: String?,

    @SerializedName("md5_image")
    val md5Image: String?,

    @SerializedName("genre_id")
    val genreId: Int?,

    @SerializedName("genres")
    val genres: String?,

    @SerializedName("label")
    val label: String?,

    @SerializedName("nb_tracks")
    val nbTracks: Int?,

    @SerializedName("duration")
    val duration: Int?,

    @SerializedName("fans")
    val fans: Int?,

    @SerializedName("release_date")
    val releaseDate: String?,

    @SerializedName("record_type")
    val recordType: String?,

    @SerializedName("available")
    val available: Boolean?,

    @SerializedName("alternative")
    val alternative: Album?,

    @SerializedName("tracklist")
    val tracklist: String?,

    @SerializedName("explicit_lyrics")
    val explicitLyrics: Boolean?,

    @SerializedName("explicit_content_lyrics")
    val explicitContentLyrics: Int?,

    @SerializedName("explicit_content_cover")
    val explicitContentCover: Int?,

    @SerializedName("contributors")
    val contributors: List<Artist>?,

    @SerializedName("artist")
    val artist: Artist?,

) : Parcelable
