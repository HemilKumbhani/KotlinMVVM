package com.example.moviedagger.ui.base

import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment(),BaseView {


    override fun onAttachView(view: BaseView) {
        mActivity!!.onAttachView(view)
    }
    override fun onDettachView() {
        mActivity!!.onDettachView()
    }
    override fun hideLoading() {
        mActivity!!.hideLoading()
    }

    override fun showLoading() {
        mActivity!!.showLoading()
    }

    abstract fun getLayoutId(): Int

    private var mActivity: BaseActivity? = null
}