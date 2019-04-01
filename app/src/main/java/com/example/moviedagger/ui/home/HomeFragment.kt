package com.example.moviedagger.ui.home

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.moviedagger.R
import com.example.moviedagger.ui.base.BaseFragment


class HomeFragment : BaseFragment() {

    private lateinit var mActivity:HomeActivity

    companion object {
        var TAG ="HomeFragment"
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }


    override fun setupView(view: View, savedInstanceState: Bundle?) {
        mActivity = activity as HomeActivity
        getActivityComponent()?.inject(this)

    }



    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()
    }


}
