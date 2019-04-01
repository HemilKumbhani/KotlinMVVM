package com.example.moviedagger.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviedagger.di.component.ActivityComponent

abstract class BaseFragment: Fragment(),BaseView {



    override fun hideLoading() {
        mActivity!!.hideLoading()
    }

    override fun showLoading() {
        mActivity!!.showLoading()
    }

    abstract fun getLayoutId(): Int

    private var mActivity: BaseActivity? = null

    abstract fun setupView(view: View, savedInstanceState: Bundle?)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        if (getLayoutId() == 0) {
            throw RuntimeException("Invalid Layout ID")
        }
        return inflater.inflate(getLayoutId(),container,false)
    }

    fun getActivityComponent(): ActivityComponent? {
        return mActivity!!.getActivityComponent()
    }


}