package com.example.moviedagger.ui.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviedagger.R
import com.example.moviedagger.data.api.response.NowPlayingMovies
import com.example.moviedagger.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedagger.data.api.response.Result


class HomeFragment : BaseFragment(), HomeView {

    private lateinit var mActivity: HomeActivity
    private lateinit var mAdapter: NowPlayinMoviesAdapter
    private var pageNo: Int = 1
    private var list:ArrayList<Result> = arrayListOf()

    @Inject
    lateinit var viewModel: HomeViewModel

    companion object {
        var TAG = "HomeFragment"
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun setupView(view: View, savedInstanceState: Bundle?) {
        mActivity = activity as HomeActivity
        getActivityComponent()?.inject(this)
        viewModel.onAttachView(this)

        var manager = GridLayoutManager(mActivity, 2);
        recyclerViewMovies.layoutManager = manager

        mAdapter = NowPlayinMoviesAdapter(mActivity)
        recyclerViewMovies.adapter = mAdapter

        recyclerViewMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = manager.getChildCount()
                val totalItemCount = manager.getItemCount()
                val firstVisibleItemPosition = manager.findFirstVisibleItemPosition()

                // Load more if we have reach the end to the recyclerView
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                    pageNo++
                    viewModel.getMovies(pageNo.toString())
                }
            }
        })


    }

    override fun onMoviesAvailable(it: NowPlayingMovies) {
        list.addAll(it.results)

        mAdapter.onDataAvailable(list)
    }
}
