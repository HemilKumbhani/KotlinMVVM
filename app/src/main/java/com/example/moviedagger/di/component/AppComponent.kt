package com.example.moviedagger.di.component

import android.app.Application
import android.content.Context
import com.example.moviedagger.AppController
import com.example.moviedagger.data.ApiServices
import com.example.moviedagger.data.AppDataManger
import com.example.moviedagger.di.ApplicationContext
import com.example.moviedagger.di.module.AppModule
import com.example.moviedagger.ui.base.BaseActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun appDataManager(): AppDataManger

    fun inject(app: AppController)

}