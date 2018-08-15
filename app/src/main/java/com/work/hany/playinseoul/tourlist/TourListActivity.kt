package com.work.hany.playinseoul.tourlist

import android.os.Bundle
import com.work.hany.playinseoul.R
import com.work.hany.playinseoul.util.ActivityUtils
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

internal class TourListActivity : DaggerAppCompatActivity() {
    @Inject
    internal lateinit var tourListFragment: Lazy<TourListFragment>

//    @Inject var contentType: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var torListFragment = tourListFragment.get()
        ActivityUtils.addFragmentToActivity(supportFragmentManager, torListFragment, R.id.contentFrame)

    }

}