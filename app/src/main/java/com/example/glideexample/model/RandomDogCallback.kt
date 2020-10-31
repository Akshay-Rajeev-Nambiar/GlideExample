package com.example.glideexample.model

interface RandomDogCallback {
    fun onResponse(data: String)
    fun onFailure(throwable: Throwable)
}