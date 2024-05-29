//package com.example.demo1.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.di_app_mad.data.ApiServices
//import com.example.di_app_mad.viewmodel.PostViewModel
//import javax.inject.Inject
//
//class PostViewModelFactory @Inject constructor(apiService: ApiServices) : ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//
//        if(modelClass.isAssignableFrom(PostViewModel::class.java))
//        {
//            return PostViewModel()
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}