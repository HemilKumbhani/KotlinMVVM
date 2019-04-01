package com.example.moviedagger.di.component

import com.example.moviedagger.di.PerActivity
import com.example.moviedagger.di.module.ActivityModule
import com.example.moviedagger.ui.base.BaseActivity
import com.example.moviedagger.ui.home.HomeActivity
import com.example.moviedagger.ui.home.HomeFragment
import dagger.Component


@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(baseActivity: BaseActivity)

    fun inject(homeActivity: HomeActivity)

    fun inject(homeFragment: HomeFragment)
}