package com.khairo.dotassignment.data.repositories.repo

import com.khairo.dotassignment.data.models.repo.Repo

interface RepoRepository {

    suspend fun getRepos(): List<Repo>?
}
