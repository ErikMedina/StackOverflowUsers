package com.example.stackoverflowusers.core.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class StackOverflowEntity(
    @SerializedName("items")
    @Expose
    var userEntities: List<UserEntity> = ArrayList(),
    @SerializedName("has_more")
    @Expose
    var hasMore: Boolean? = null,
    @SerializedName("quota_max")
    @Expose
    var quotaMax: Int? = null,
    @SerializedName("quota_remaining")
    @Expose
    var quotaRemaining: Int? = null
)
