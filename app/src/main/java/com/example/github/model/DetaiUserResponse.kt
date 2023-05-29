package com.example.github.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailUserResponse(
    @field:SerializedName("login")
    val login: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @field:SerializedName("following_url")
	val followingUrl: String? = null,

	@field:SerializedName("followers_url")
	val followersUrl: String? = null,

    @field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("following")
	val following: Int? = null,

	@field:SerializedName("followers")
	val followers: Int? = null,
) : Parcelable
