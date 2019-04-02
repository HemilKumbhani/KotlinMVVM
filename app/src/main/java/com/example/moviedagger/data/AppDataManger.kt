package com.example.moviedagger.data

import android.content.Context
import com.example.moviedagger.data.api.response.NowPlayingMovies
import com.example.moviedagger.di.ApplicationContext
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManger
@Inject internal constructor(@ApplicationContext val context: Context,
                             private val apiServices: ApiServices):ApiServices{

    override fun getMovies(apikey: String, page: String): Observable<NowPlayingMovies> {
        return apiServices.getMovies(apikey,page)
    }

}