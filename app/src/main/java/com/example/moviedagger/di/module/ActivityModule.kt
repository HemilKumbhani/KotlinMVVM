package com.example.moviedagger.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.moviedagger.di.ActivityContext
import com.example.moviedagger.utils.AppSchedulerProvider
import com.example.moviedagger.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule constructor(val mActivity: AppCompatActivity){

    @Provides
    @ActivityContext
    internal fun provideContext():Context{
           return mActivity
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }






}