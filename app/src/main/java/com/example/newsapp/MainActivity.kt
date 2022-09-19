package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.adapter.NewsRvAdapter
import com.example.newsapp.model.NewsModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<NewsModel>()
        for (i in 1..20) {
            data.add(NewsModel(0,R.drawable.hamropatrologo,"Title","Description"))
            val adapter = NewsRvAdapter(data)

            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter
        }



    }
}