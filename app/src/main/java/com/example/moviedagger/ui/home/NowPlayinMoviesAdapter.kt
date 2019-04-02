package com.example.moviedagger.ui.home

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedagger.R
import com.example.moviedagger.data.api.response.Result
import com.example.moviedagger.data.api.response.NowPlayingMovies
import kotlinx.android.synthetic.main.item_movie.view.*

class NowPlayinMoviesAdapter(var context: Context) : RecyclerView.Adapter<ViewHolder>() {

    private var moveList: ArrayList<Result> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return moveList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load("https://image.tmdb.org/t/p/w500/" + moveList[position].posterPath)
            .into(holder.itemView.imgMovie)
        holder.itemView.movieName.setText(moveList[position].title)


    }

    fun onDataAvailable(list: ArrayList<Result>) {
        moveList = list
        notifyDataSetChanged()
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}
