package com.example.moviedagger.data.api

import com.example.moviedagger.data.ApiServices
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient{
    companion object {
        const val HTTP_CONNECT_TIMEOUT = 30 * 1000
        const val HTTP_READ_TIMEOUT = 30 * 1000
        const val AUTHORIZATION = "Authorization"
        const val LANGUAGE = "Accept-Language"
        private lateinit var retrofit: Retrofit
        const val BASE_URL = "https://x76h951q.dtechno.co.uk/"
    }


    init {
        val gson: Gson = with(GsonBuilder()) {
            setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            create()
        }

        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient: OkHttpClient = with(OkHttpClient.Builder()) {
            connectTimeout(HTTP_CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            readTimeout(HTTP_READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            writeTimeout(HTTP_READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
            addInterceptor(interceptor)
            build()
        }

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun getApiServices() = retrofit.create(ApiServices::class.java)
}