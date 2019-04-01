package com.example.moviedagger.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviedagger.AppController
import com.example.moviedagger.di.component.ActivityComponent
import com.example.moviedagger.di.component.DaggerActivityComponent
import com.example.moviedagger.di.module.ActivityModule
import dagger.android.DaggerActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BaseActivity: AppCompatActivity(),BaseView {


     abstract fun getLayout():Int

     override fun onAttachView(view: BaseView) {


     }
     override fun onDettachView() {

     }
     override fun hideLoading() {

     }
     override fun showLoading() {

     }
    @Inject
    lateinit var mComponentDisposable: CompositeDisposable

    lateinit var mActivityComponent:ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityComponent= DaggerActivityComponent.builder()
            .appComponent((application as AppController).mAppComponent)
            .activityModule(ActivityModule(this))
            .build()



    }
 }