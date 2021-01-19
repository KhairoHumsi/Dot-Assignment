package com.khairo.dotassignment.data.network

import com.khairo.dotassignment.data.models.contributors.Contributors
import com.khairo.dotassignment.data.models.repo.Repo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface EndPointInterface {

    @GET("users/romannurik/repos")
    suspend fun getRepos(): Response<List<Repo>>

    @GET
    suspend fun getContributors(@Url path: String): Response<List<Contributors>>
}
