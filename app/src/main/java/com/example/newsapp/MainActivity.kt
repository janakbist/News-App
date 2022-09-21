package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.adapter.NewsRvAdapter
import com.example.newsapp.model.NewsAppModel
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.network.NewsReceiver
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
//
//        recyclerview.layoutManager = LinearLayoutManager(this)
//        val data = ArrayList<NewsAppModel>()
//        for (i in 1..20) {
//            data.add(NewsAppModel("Description","Title",R.drawable.hamropatrologo))
//            val adapter = NewsRvAdapter(data)
//
//            // Setting the Adapter with the recyclerview
//            recyclerview.adapter = adapter
//        }
        initRecyclerview()
        fetchNewsAppModel()



    }

    private fun fetchNewsAppModel() {
        val  newsFetchJob = Job()
        val errorHandler = CoroutineExceptionHandler{coroutineContext,throwable ->
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
        }
        val scope = CoroutineScope(newsFetchJob + Dispatchers.Main)
        scope.launch(errorHandler) {
            val newsReceiver : NewsReceiver = NewsReceiver()

            //fetched data
            val news = newsReceiver.getNewsAppModel()
            //render data in recycler view
            renderData(NewsResponse)
        }
    }

    private fun renderData(newsResponse: NewsResponse) {

    }

    private fun initRecyclerview() {
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    fun onItemClicked(item:NewsAppModel) {

    }
}