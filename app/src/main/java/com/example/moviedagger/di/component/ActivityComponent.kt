package com.example.moviedagger.di.component

import com.example.moviedagger.di.PerActivity
import com.example.moviedagger.di.module.ActivityModule
import com.example.moviedagger.ui.base.BaseActivity
import dagger.Component


@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(baseActivity: BaseActivity)
}