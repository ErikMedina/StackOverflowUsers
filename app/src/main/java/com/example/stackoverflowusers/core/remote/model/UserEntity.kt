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
    var accountId: Int,
    @SerializedName("is_employee")
    @Expose
    var isEmployee: Boolean,
    @SerializedName("last_modified_date")
    @Expose
    var lastModifiedDate: Int,
    @SerializedName("last_access_date")
    @Expose
    var lastAccessDate: Int,
    @SerializedName("age")
    @Expose
    var age: Int,
    @SerializedName("reputation_change_year")
    @Expose
    var reputationChangeYear: Int,
    @SerializedName("reputation_change_quarter")
    @Expose
    var reputationChangeQuarter: Int,
    @SerializedName("reputation_change_month")
    @Expose
    var reputationChangeMonth: Int,
    @SerializedName("reputation_change_week")
    @Expose
    var reputationChangeWeek: Int,
    @SerializedName("reputation_change_day")
    @Expose
    var reputationChangeDay: Int,
    @SerializedName("reputation")
    @Expose
    var reputation: Int,
    @SerializedName("creation_date")
    @Expose
    var creationDate: Int,
    @SerializedName("user_type")
    @Expose
    var userType: String,
    @SerializedName("user_id")
    @Expose
    var userId: Int,
    @SerializedName("accept_rate")
    @Expose
    var acceptRate: Int,
    @SerializedName("location")
    @Expose
    var location: String,
    @SerializedName("website_url")
    @Expose
    var websiteUrl: String,
    @SerializedName("link")
    @Expose
    var link: String,
    @SerializedName("profile_image")
    @Expose
    var profileImage: String = "N/A",
    @SerializedName("display_name")
    @Expose
    var displayName: String = "N/A"
) {

    fun toUser() = User(userId, displayName, profileImage, age)
}
