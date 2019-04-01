package com.example.moviedagger.di.module

import android.app.Application
import android.content.Context
import com.example.moviedagger.data.api.ApiClient
import com.example.moviedagger.data.ApiServices
import com.example.moviedagger.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule constructor(val mApplication: Application) {

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return mApplication
    }

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @Singleton
    internal fun provideApiService(): ApiServices {
        return ApiClient().getApiServices()
    }







}