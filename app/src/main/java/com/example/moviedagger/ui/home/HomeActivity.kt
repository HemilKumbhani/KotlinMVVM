package com.example.moviedagger.ui.home

import com.example.moviedagger.R
import com.example.moviedagger.di.component.ActivityComponent
import com.example.moviedagger.ui.base.BaseActivity

class HomeActivity : BaseActivity() {


    override fun injectComponents(mActivityComponent: ActivityComponent) {
        mActivityComponent.inject(this)

    }

    override fun getLayout(): Int {
        return R.layout.activity_home
    }

    override fun setUp() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, HomeFragment()).commit()

    }


}
