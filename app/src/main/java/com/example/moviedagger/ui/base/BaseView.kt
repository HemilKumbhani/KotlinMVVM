package com.example.moviedagger.ui.base

interface BaseView {

    fun onAttachView(view:BaseView)

    fun onDettachView()

    fun hideLoading()

    fun showLoading()




}