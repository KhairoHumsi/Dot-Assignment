package com.khairo.dotassignment.data.impl

import android.content.Context
import com.khairo.dotassignment.R
import com.khairo.dotassignment.data.models.contributors.Contributors
import com.khairo.dotassignment.data.models.repo.Repo
import com.khairo.dotassignment.data.network.EndPointInterface
import com.khairo.dotassignment.data.repositories.repoDetails.RepoDetailsRepository
import com.khairo.utils.ResponseHelper
import com.khairo.utils.isOnline
import com.khairo.utils.log
import com.khairo.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class RepoDetailsRepositoryImpl @Inject constructor(
    private val context: Context,
    private val api: EndPointInterface,
    private val responseHelper: ResponseHelper<List<Contributors>>
) : RepoDetailsRepository {

    override suspend fun getContributors(path: String): List<Contributors>? {
        var retuningValue: List<Contributors>? = null

        if (context.isOnline())
            api.getContributors(path = path).run {
                TAG.log("getContributors()-> ${this.raw().request}")
                responseHelper.checkResponse(this) { message, data ->
                    retuningValue = if (data != null) body()
                    else {
                        runBlocking(Dispatchers.Main) { message!!.toast(context = context) }
                        null
                    }
                }
            }
        else {
            runBlocking { R.string.toast_internet_error.toast(context = context) }
            retuningValue = null
        }

        return retuningValue
    }

    companion object {
        const val TAG = "RepoDetailsRepositoryImpl"
    }
}
