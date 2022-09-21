package com.example.newsapp.network

import com.example.newsapp.model.NewsAppModel
import com.example.newsapp.model.NewsResponse
import retrofit2.http.GET

interface NetworkInterface {
    @GET("/NewsAppModel")
    suspend fun getNewsAppModel() :NewsResponse
}