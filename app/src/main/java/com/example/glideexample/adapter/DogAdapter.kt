package com.example.glideexample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.glideexample.R

class DogAdapter(
    private val context: Context,
    private val dogList: List<String>
) : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {
    class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogImage: ImageView = itemView.findViewById(R.id.dog_iv)
        val dogNameTv: TextView = itemView.findViewById(R.id.dog_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.dog_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        Glide.with(context)
            .load(dogList[position])
            .into(holder.dogImage)
        holder.dogNameTv.text = stripDogName(dogList[position])
    }

    override fun getItemCount(): Int = dogList.size

    private fun stripDogName(dogUrl: String): String{
        var endIndex = 0
        for (i in (30..dogUrl.length)){
            if (dogUrl[i] == '/')   break
            else endIndex = i
        }
        return dogUrl.substring(30, endIndex+1)
    }

}