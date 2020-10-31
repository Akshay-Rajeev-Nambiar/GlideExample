package com.example.glideexample.model

interface DogListCallback {
    fun onResponse(data: List<String>)
    fun onFailure(throwable: Throwable)
}