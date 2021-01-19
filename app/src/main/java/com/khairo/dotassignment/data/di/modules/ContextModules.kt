package com.khairo.dotassignment.data.di.modules

import android.content.Context
import com.khairo.dotassignment.common.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * this Module is using to provide the context in dagger to use it without passing context to classes
 *
 */

@Module
@InstallIn(ApplicationComponent::class)
class ContextModules {

    @Singleton
    @Provides
    fun providesContext(): Context = App.instance.applicationContext
}
