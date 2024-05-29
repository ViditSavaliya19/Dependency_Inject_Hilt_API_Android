package com.example.di_app_mad.repository

import com.example.di_app_mad.data.ApiServices
import com.example.di_app_mad.domain.ApiResponse
import com.example.di_app_mad.domain.PostModel
import retrofit2.await
import javax.inject.Inject

class NetworkRepository @Inject constructor(val apiServices: ApiServices) {

    suspend fun getPostData(): List<PostModel> {
            return apiServices.getPosts().await()
      
    }
}