package com.example.di_app_mad.domain

sealed class ApiResponse<out T:Any> {

    data class Success<out T:Any>(val data:T):ApiResponse<T>()
    data class Error(val exception:Exception):ApiResponse<Nothing>()
    data object Loading:ApiResponse<Nothing>()


}