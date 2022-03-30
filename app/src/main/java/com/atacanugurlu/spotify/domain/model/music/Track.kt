package com.atacanugurlu.spotify.domain.model.music

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tracks_table")
data class Track(

    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("readable")
    val readable: Boolean?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("title_short")
    val titleShort: String?,

    @SerializedName("title_version")
    val titleVersion: String?,

    @SerializedName("unseen")
    val unseen: Boolean?,

    @SerializedName("isrc")
    val isrc: String?,

    @SerializedName("link")
    val link: String?,

    @SerializedName("share")
    val share: String?,

    @SerializedName("duration")
    val duration: Int?,

    @SerializedName("track_position")
    val trackPosition: Int?,

    @SerializedName("disk_number")
    val diskNumber: Int?,

    @SerializedName("rank")
    val rank: Int?,

    @SerializedName("release_date")
    val releaseDate: String?,

    @SerializedName("explicit_lyrics")
    val explicitLyrics: Boolean?,

    @SerializedName("explicit_content_lyrics")
    val explicitContentLyrics: Int?,

    @SerializedName("explicit_content_cover")
    val explicitContentCover: Int?,

    @SerializedName("preview")
    val preview: String?,

    @SerializedName("bpm")
    val bpm: Float?,

    @SerializedName("gain")
    val gain: Float?,

    @SerializedName("available_countries")
    val availableCountries: String?,

    /*
    @SerializedName("alternative")
    val alternative: Track?,



    @SerializedName("contributors")
    val contributors: List<Artist>?,

    @SerializedName("md5_image")
    val md5Image: String?,

    @SerializedName("artist")
    val artist: Artist?,

    @SerializedName("album")
    val album: Album?,
    */
) : Parcelable
