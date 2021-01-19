package com.khairo.dotassignment.data.models.repo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Repo(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("created_at")
    var createdAt: String,
    @SerializedName("size")
    var size: Int,
    @SerializedName("watchers_count")
    var watchersCount: Int,
    @SerializedName("language")
    var language: String,
    @SerializedName("forks_count")
    var forksCount: Int,
    @SerializedName("forks")
    var forks: Int,
    @SerializedName("watchers")
    var watchers: Int,
    @SerializedName("contributors_url")
    var contributorsUrl: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("owner")
    var owner: Owner
) : Parcelable
