package com.khairo.dotassignment.common

import android.app.Application
import com.khairo.dotassignment.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

    }

    companion object {
        lateinit var instance: App
    }
}
