package com.example.github.api

import com.example.github.model.DetailUserResponse
import com.example.github.model.User
import com.example.github.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path ("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path ("username") username: String
    ): Call<ArrayList<User>>
}