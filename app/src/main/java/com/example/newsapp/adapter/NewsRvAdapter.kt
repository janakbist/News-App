package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.model.NewsAppModel
import com.example.newsapp.model.RecyclerData
import com.squareup.picasso.Picasso

class NewsRvAdapter(private val listener :NewsItemClicked): RecyclerView.Adapter<NewsViewHolder>() {
    private val items:ArrayList<NewsAppModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rvlist,parent,false)
        val viewHolder = NewsViewHolder(view)

        view.setOnLongClickListener {
            listener.onItemClicked(items[viewHolder.absoluteAdapterPosition])
        }
        return NewsViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentitem = items[position]
        holder.title.text = currentitem.title
        holder.description.text = currentitem.description
        holder.image.setImageResource(R.drawable.hamropatrologo)
    }
    fun updateNews(updateNews:ArrayList<NewsAppModel>) {
        items.clear()
        items.addAll(updateNews)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
       return items.size
    }


}

class NewsViewHolder(itemView :View) :RecyclerView.ViewHolder(itemView) {
    val title : TextView = itemView.findViewById(R.id.title)
    val description :TextView = itemView.findViewById(R.id.description)
    val image :ImageView = itemView.findViewById(R.id.image)

}
interface NewsItemClicked {
     fun onItemClicked(item:NewsAppModel) {

    }
}