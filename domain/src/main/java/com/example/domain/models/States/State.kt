package com.example.domain.models.States

sealed class State<out T>{
    data class Success<T>(val data:T): State<T>()
    data class Error(val message:String): State<Nothing>()
    object Loading: State<Nothing>()
    data class NoDataCached(val message:String): State<Nothing>()
    fun toData():T? = if (this is Success) data else null
}