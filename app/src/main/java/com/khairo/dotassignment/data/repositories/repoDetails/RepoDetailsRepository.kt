package com.khairo.dotassignment.data.repositories.repoDetails

import com.khairo.dotassignment.data.models.contributors.Contributors

interface RepoDetailsRepository {

    suspend fun getContributors(path: String): List<Contributors>?
}
