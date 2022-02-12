package com.example.stackoverflowusers.core.remote.model

import com.example.stackoverflowusers.core.local.model.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * This is the User model for the Server
 */
data class UserEntity(
    @SerializedName("account_id")
    @Expose
    var accountId: Int? = null,
    @SerializedName("is_employee")
    @Expose
    var isEmployee: Boolean? = null,
    @SerializedName("last_modified_date")
    @Expose
    var lastModifiedDate: Int? = null,
    @SerializedName("last_access_date")
    @Expose
    var lastAccessDate: Int? = null,
    @SerializedName("age")
    @Expose
    var age: Int? = null,
    @SerializedName("reputation_change_year")
    @Expose
    var reputationChangeYear: Int? = null,
    @SerializedName("reputation_change_quarter")
    @Expose
    var reputationChangeQuarter: Int? = null,
    @SerializedName("reputation_change_month")
    @Expose
    var reputationChangeMonth: Int? = null,
    @SerializedName("reputation_change_week")
    @Expose
    var reputationChangeWeek: Int? = null,
    @SerializedName("reputation_change_day")
    @Expose
    var reputationChangeDay: Int? = null,
    @SerializedName("reputation")
    @Expose
    var reputation: Int,
    @SerializedName("creation_date")
    @Expose
    var creationDate: Int? = null,
    @SerializedName("user_type")
    @Expose
    var userType: String? = null,
    @SerializedName("user_id")
    @Expose
    var userId: Int,
    @SerializedName("accept_rate")
    @Expose
    var acceptRate: Int? = null,
    @SerializedName("location")
    @Expose
    var location: String? = null,
    @SerializedName("website_url")
    @Expose
    var websiteUrl: String? = null,
    @SerializedName("link")
    @Expose
    var link: String? = null,
    @SerializedName("profile_image")
    @Expose
    var profileImage: String = "N/A",
    @SerializedName("display_name")
    @Expose
    var displayName: String = "N/A"
) {

    fun mapToUser() = User(userId, displayName, profileImage, reputation)
}
