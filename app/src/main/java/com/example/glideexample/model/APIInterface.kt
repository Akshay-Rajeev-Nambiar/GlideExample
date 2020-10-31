package com.example.glideexample.model

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("random")
    fun getRandomDogData(): Call<RandomDog>

    @GET("random/30")
    fun getRandomDogList(): Call<RandomDogList>
}