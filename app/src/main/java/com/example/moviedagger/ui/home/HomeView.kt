package com.example.moviedagger.ui.home

import com.example.moviedagger.data.api.response.NowPlayingMovies
import com.example.moviedagger.ui.base.BaseView

interface HomeView : BaseView {
    fun onMoviesAvailable(it: NowPlayingMovies)

}