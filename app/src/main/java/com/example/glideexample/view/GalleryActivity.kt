package com.example.glideexample.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.glideexample.*
import com.example.glideexample.adapter.DogAdapter
import com.example.glideexample.model.APIInterface
import com.example.glideexample.model.DogListCallback
import com.example.glideexample.model.RandomDogList
import com.example.glideexample.model.RetrofitInitializer
import com.example.glideexample.viewmodel.DogViewModel
import kotlinx.android.synthetic.main.activity_gallery.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        dog_gallery_rv.layoutManager = LinearLayoutManager(this@GalleryActivity)

        val dogViewModel = ViewModelProviders.of(this@GalleryActivity).get(DogViewModel::class.java)
        dogViewModel.randomDogDataList(object : DogListCallback {
            override fun onResponse(data: List<String>) {
                dog_gallery_rv.adapter = DogAdapter(this@GalleryActivity, data)
            }

            override fun onFailure(throwable: Throwable) {
                Toast.makeText(this@GalleryActivity, throwable.toString(), Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }

}