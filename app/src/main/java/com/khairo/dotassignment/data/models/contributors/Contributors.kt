package com.khairo.dotassignment.data.models.contributors

import com.google.gson.annotations.SerializedName


data class Contributors(
    @SerializedName("id")
    var id: Int,
    @SerializedName("login")
    var name: String,
    @SerializedName("avatar_url")
    var avatar_url: String
)