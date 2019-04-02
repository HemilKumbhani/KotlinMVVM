package com.example.moviedagger.data

import com.example.moviedagger.data.api.response.NowPlayingMovies
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiServices {


    @POST("now_playing")
    fun getMovies(@Query ("api_key") apikey:String,@Query("page") page:String):Observable<NowPlayingMovies>



}