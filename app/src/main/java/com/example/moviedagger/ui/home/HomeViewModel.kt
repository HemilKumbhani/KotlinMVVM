package com.example.moviedagger.ui.home

import com.example.moviedagger.BaseViewModel
import com.example.moviedagger.BuildConfig
import com.example.moviedagger.data.ApiServices
import com.example.moviedagger.data.AppDataManger
import com.example.moviedagger.di.PerActivity
import com.example.moviedagger.ui.base.BaseView
import com.example.moviedagger.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@PerActivity
class HomeViewModel
@Inject constructor(
    appDataManger: AppDataManger,
    mSchedulerProvider: SchedulerProvider,
    mCompositeDisposable: CompositeDisposable
) : BaseViewModel(appDataManger, mSchedulerProvider, mCompositeDisposable) {

    var mView: HomeView? = null

    override fun onAttachView(view: BaseView) {
        super.onAttachView(view)
        mView = view as HomeView

        getMovies( "1")

    }

    fun getMovies(pageNo:String) {
        mCompositeDisposable.add(
            appDataManger.getMovies(BuildConfig.apiKey, pageNo)
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe({
                    mView?.onMoviesAvailable(it)
                }, {
                    it.printStackTrace()
                })
        )
    }
}

