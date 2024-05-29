package com.example.di_app_mad.data

import com.example.di_app_mad.domain.ApiResponse
import com.example.di_app_mad.domain.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    @GET("posts")
    fun getPosts(): Call<List<PostModel>>

}