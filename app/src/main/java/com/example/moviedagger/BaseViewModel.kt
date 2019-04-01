package com.example.moviedagger


import androidx.lifecycle.ViewModel
import com.example.moviedagger.ui.base.BaseView
import com.example.moviedagger.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel(val mSchedulerProvider: SchedulerProvider,
                         val mCompositeDisposable: CompositeDisposable) : ViewModel() {

  /*  companion object {
        val TAG = BaseViewModel.javaClass.canonicalName
    }*/

    var view: BaseView? = null

    open fun isViewAttached(): Boolean {
        return view != null
    }

    open fun onAttachView(view: BaseView) {
        this.view = view
    }

    fun onDetachView() {
        mCompositeDisposable.dispose()
        view = null
    }

    open fun getBaseView(): BaseView? {
        return view
    }
}