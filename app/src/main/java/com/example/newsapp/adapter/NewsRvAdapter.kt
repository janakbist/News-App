package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.model.NewsModel

class NewsRvAdapter(private val mList:List<NewsModel>) :RecyclerView.Adapter<NewsRvAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val title :TextView = itemView.findViewById(R.id.title)
        var description:TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rvlist, parent, false)

        return NewsViewHolder(view)    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val NewsModel = mList[position]
        holder.image.setImageResource(NewsModel.image)
        holder.title.text = NewsModel.title
        holder.description.text =  NewsModel.description
     }

    override fun getItemCount(): Int {
        return mList.size
    }
}