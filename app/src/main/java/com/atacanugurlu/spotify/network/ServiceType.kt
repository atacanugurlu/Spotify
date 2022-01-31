package com.atacanugurlu.spotify.network

import androidx.annotation.Keep

@Keep
sealed class ServiceType {
    object Artists: ServiceType()
    object Albums: ServiceType()
    object Tracks: ServiceType()
}