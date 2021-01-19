package com.khairo.dotassignment.data.models.repo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    @SerializedName("id")
    var id: Int,
    @SerializedName("avatar_url")
    var avatarUrl: String,
    @SerializedName("gravatar_id")
    var gravatarId: String,
    @SerializedName("type")
    var type: String,
    @SerializedName("site_admin")
    var siteAdmin: Boolean
) : Parcelable
