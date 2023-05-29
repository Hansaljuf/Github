package com.example.github.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
//    val login: String,
//    val id: Int,
//    val avatar_url: String

    @field:SerializedName("login")
	val login: String? = null,

    @field:SerializedName("id")
	val id: Int? = null,

    @field:SerializedName("avatar_url")
	val avatarUrl: String? = null,
) : Parcelable
