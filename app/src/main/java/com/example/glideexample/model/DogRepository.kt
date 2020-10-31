package com.example.glideexample.model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogRepository {
    private val retrofit = RetrofitInitializer.getInstance().create(APIInterface::class.java)

    fun getRandomDogData(modelCallback: RandomDogCallback) {
        val dogData = retrofit.getRandomDogData()
        dogData.enqueue(object : Callback<RandomDog> {
            override fun onResponse(call: Call<RandomDog>, response: Response<RandomDog>) {
                modelCallback.onResponse(response.body()!!.message)
            }

            override fun onFailure(call: Call<RandomDog>, t: Throwable) {
                modelCallback.onFailure(t)
            }

        })
    }

    fun getDogDataList(modelCallback: DogListCallback) {
        val dogData = retrofit.getRandomDogList()
        dogData.enqueue(object : Callback<RandomDogList> {
            override fun onResponse(call: Call<RandomDogList>, response: Response<RandomDogList>) {
                modelCallback.onResponse(response.body()!!.message)
            }

            override fun onFailure(call: Call<RandomDogList>, t: Throwable) {
                modelCallback.onFailure(t)
            }

        })
    }

}