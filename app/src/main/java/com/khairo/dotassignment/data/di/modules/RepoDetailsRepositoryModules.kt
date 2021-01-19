package com.khairo.dotassignment.data.di.modules

import android.content.Context
import com.khairo.dotassignment.data.impl.RepoDetailsRepositoryImpl
import com.khairo.dotassignment.data.models.contributors.Contributors
import com.khairo.dotassignment.data.network.EndPointInterface
import com.khairo.dotassignment.data.repositories.repoDetails.RepoDetailsRepository
import com.khairo.utils.ResponseHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepoDetailsRepositoryModules {

    @Singleton
    @Provides
    fun providesRepository(
        context: Context,
        api: EndPointInterface,
        responseHelper: ResponseHelper<List<Contributors>>
    ): RepoDetailsRepository =
        RepoDetailsRepositoryImpl(context = context, api = api, responseHelper = responseHelper)
}
