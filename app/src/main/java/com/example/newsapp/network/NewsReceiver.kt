package com.example.newsapp.network

import com.example.newsapp.model.NewsAppModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsReceiver {
    private val newsInterface : NewsInterface
    companion object {
        val BaseURL = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=c9af074fff3641899c3d54ab5e20f254"
    }
    init {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInterface = retrofit.create(NewsInterface::Class.java)
    }
    suspend fun getNewsAppModel():NewsReceiver {
        return newsInterface.getNewsAppModel()
    }

}