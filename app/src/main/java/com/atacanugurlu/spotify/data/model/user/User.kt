package com.atacanugurlu.spotify.data.model.user

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Long,

    @ColumnInfo(name = "email")
    @SerializedName("email") val email: String?,

    @ColumnInfo(name = "password")
    @SerializedName("password") val password: String?,

    @ColumnInfo(name = "birth_date")
    @SerializedName("birth_date") val birth_date: String?,

    @ColumnInfo(name = "gender")
    @SerializedName("gender") val gender: String?,

    @ColumnInfo(name = "name")
    @SerializedName("name") val name: String?

) : Parcelable
