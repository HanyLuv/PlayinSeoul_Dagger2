package com.work.hany.playinseoul.toursearch

import com.work.hany.playinseoul.BasePresenter
import com.work.hany.playinseoul.BaseView
import com.work.hany.playinseoul.model.ContentType
import com.work.hany.playinseoul.network.AreaTour
import java.util.ArrayList


class SearchContact {
    interface View : BaseView<Presenter> {
//        fun initTourListUi(areaTourList: ArrayList<AreaTour>)
//        fun showTourDetailsUi(areaTour: AreaTour)
//        void setLoadingIndicator(boolean active);
    }


    interface Presenter : BasePresenter<View> {
//        fun openTourDetails(areaTour: AreaTour)
        fun loadAreaCode()

    }
}