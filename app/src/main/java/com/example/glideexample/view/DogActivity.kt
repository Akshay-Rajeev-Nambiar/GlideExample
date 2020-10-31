package com.example.glideexample.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.glideexample.*
import com.example.glideexample.model.RandomDogCallback
import com.example.glideexample.viewmodel.DogViewModel
import kotlinx.android.synthetic.main.activity_dog.*

class DogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog)
        val dogViewModel = ViewModelProviders.of(this).get(DogViewModel::class.java)
        random_btn.setOnClickListener {
            dogViewModel.randomDogData(object : RandomDogCallback {
                override fun onResponse(data: String) {
                    dog_name.text = dogViewModel.stripDogName(data)
                    Glide.with(this@DogActivity)
                        .load(data)
                        .into(dog_iv)
                }

                override fun onFailure(throwable: Throwable) {
                    Toast.makeText(this@DogActivity, throwable.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }
        gallery_btn.setOnClickListener {
            startActivity(Intent(this@DogActivity, GalleryActivity::class.java))
        }
    }
}