package com.example.di_app_mad.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.di_app_mad.data.ApiServices
import com.example.di_app_mad.domain.ApiResponse
import com.example.di_app_mad.domain.PostModel
import com.example.di_app_mad.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(val repo: NetworkRepository) : ViewModel() {

    var list = MutableLiveData<ApiResponse<List<PostModel>>>()
    val postLiveData: LiveData<ApiResponse<List<PostModel>>> = list


    init {
        viewModelScope.launch {
            list.value = ApiResponse.Loading

            try {
                val response = repo.getPostData()
                list.value = ApiResponse.Success(response)

            } catch (e: Exception) {
                list.value = ApiResponse.Error(e)
            }


//            if (list.value is ApiResponse.Success) {
//                Log.e("TAG", ":Success ${list.value}")
//            } else if (list.value is ApiResponse.Error) {
//                Log.e("TAG", ":Failed ${list.value}")
//
//            } else {
//                Log.e("TAG", ": Loading.... ${list.value}")
//            }
        }
    }


}