package com.example.glideexample.viewmodel

import androidx.lifecycle.ViewModel
import com.example.glideexample.model.DogListCallback
import com.example.glideexample.model.DogRepository
import com.example.glideexample.model.RandomDogCallback

class DogViewModel : ViewModel() {
    private val dogRepository = DogRepository()

    fun randomDogData(modelCallback: RandomDogCallback) {
        dogRepository.getRandomDogData(object : RandomDogCallback {
            override fun onResponse(data: String) {
                modelCallback.onResponse(data)
            }

            override fun onFailure(throwable: Throwable) {
                modelCallback.onFailure(throwable)
            }

        })
    }

    fun randomDogDataList(modelCallback: DogListCallback) {
        dogRepository.getDogDataList(object : DogListCallback {
            override fun onResponse(data: List<String>) {
                modelCallback.onResponse(data)
            }

            override fun onFailure(throwable: Throwable) {
                modelCallback.onFailure(throwable)
            }

        })
    }

    fun stripDogName(dogUrl: String): String{
        var endIndex = 0
        for (i in (30..dogUrl.length)){
            if (dogUrl[i] == '/')   break
            else endIndex = i
        }
        return dogUrl.substring(30, endIndex+1)
    }
}