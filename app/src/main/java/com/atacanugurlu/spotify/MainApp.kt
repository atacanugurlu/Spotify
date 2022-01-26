package com.atacanugurlu.spotify

import android.app.Application
import com.atacanugurlu.spotify.di.AppComponent
import com.atacanugurlu.spotify.di.DaggerAppComponent

class MainApp : Application() {

    companion object {
        lateinit var instance: MainApp
            private set
    }

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        initComponent()
    }

    private fun initComponent() {
        appComponent = DaggerAppComponent.builder()
            .build()
        appComponent.inject(this)


    }


}