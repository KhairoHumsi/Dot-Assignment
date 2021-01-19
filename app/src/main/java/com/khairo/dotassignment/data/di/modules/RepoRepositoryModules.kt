package com.khairo.dotassignment.data.di.modules

import android.content.Context
import com.khairo.dotassignment.data.impl.RepoRepositoryImpl
import com.khairo.dotassignment.data.models.repo.Repo
import com.khairo.dotassignment.data.network.EndPointInterface
import com.khairo.dotassignment.data.repositories.repo.RepoRepository
import com.khairo.utils.ResponseHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepoRepositoryModules {

    @Singleton
    @Provides
    fun providesRepository(
        context: Context,
        api: EndPointInterface,
        responseHelper: ResponseHelper<List<Repo>>
    ): RepoRepository =
        RepoRepositoryImpl(context = context, api = api, responseHelper = responseHelper)
}
