package com.example.moviedagger.ui.home

import android.content.Context
import com.example.moviedagger.BaseViewModel
import com.example.moviedagger.data.ApiServices
import com.example.moviedagger.di.ApplicationContext
import com.example.moviedagger.ui.base.BaseView
import com.example.moviedagger.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel
@Inject constructor(
    apiServices: ApiServices,
    mSchedulerProvider: SchedulerProvider,
    mCompositeDisposable: CompositeDisposable
) : BaseViewModel(apiServices, mSchedulerProvider, mCompositeDisposable) {

    var mView: HomeView? = null

    override fun onAttachView(view: BaseView) {
        super.onAttachView(view)



    }
}

