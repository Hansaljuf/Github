package com.example.github.ui.detail.following

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.github.api.RetrofitClient
import com.example.github.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Tag

class FollowingViewModel: ViewModel() {
    val listFollowing = MutableLiveData<ArrayList<User>>()


    fun setListFollowing (username: String){
        RetrofitClient.apiInstance
            .getFollowing(username)
            .enqueue(object: Callback<ArrayList<User>>{
                override fun onResponse(
                    call: Call<ArrayList<User>>,
                    response: Response<ArrayList<User>>,
                ) {
                    if (response.isSuccessful){
                        listFollowing.postValue(response.body())
                    } else {
                        Log.e(TAG, "Fail: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                   Log.e(TAG, "onFailure: ${t.message}")
                }

            })
    }

    fun getListFollowing(): LiveData<ArrayList<User>>{
        return listFollowing
    }
}