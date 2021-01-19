package com.khairo.dotassignment.data.impl

import android.content.Context
import com.khairo.dotassignment.R
import com.khairo.dotassignment.data.models.repo.Repo
import com.khairo.dotassignment.data.network.EndPointInterface
import com.khairo.dotassignment.data.repositories.repo.RepoRepository
import com.khairo.utils.ResponseHelper
import com.khairo.utils.isOnline
import com.khairo.utils.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class RepoRepositoryImpl @Inject constructor(
    private val context: Context,
    private val api: EndPointInterface,
    private val responseHelper: ResponseHelper<List<Repo>>
) : RepoRepository {

    override suspend fun getRepos(): List<Repo>? {
        var retuningValue: List<Repo>? = null
        if (context.isOnline())
            api.getRepos().run {
                responseHelper.checkResponse(this) { message, data ->
                    retuningValue = if (data != null) body()
                    else {
                        runBlocking(Dispatchers.Main) { message!!.toast(context = context) }
                        null
                    }
                }
            }
        else {
            runBlocking(Dispatchers.Main) { R.string.toast_internet_error.toast(context = context) }
            retuningValue = null
        }

        return retuningValue
    }

}
