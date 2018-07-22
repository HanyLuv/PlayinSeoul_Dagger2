package com.work.hany.playinseoul.tourdetail.stay;

import com.work.hany.playinseoul.BasePresenter;
import com.work.hany.playinseoul.BaseView;
import com.work.hany.playinseoul.model.dao.StayDetail;
import com.work.hany.playinseoul.model.dao.TourDetail;
import com.work.hany.playinseoul.model.dao.TourIntro;
import com.work.hany.playinseoul.network.AreaTour;
import com.work.hany.playinseoul.network.TourPhoto;

import java.util.ArrayList;

public interface StayDetailContract {

    interface View extends BaseView<Presenter> {
//        void initTourOverviewUi(AreaTour areaTour);
        void initTourOverviewUi(AreaTour areaTour);
        void initTourIntroUi(TourIntro information);
        void initTourDetailUi(ArrayList<StayDetail> stayDetails);
        void initTourPhotosUi(ArrayList<TourPhoto> photos); //TODO 음... 음식때도 이거호출할텐데 이름변경생각해보자
    }

    interface Presenter extends BasePresenter<View> {
        @Override
        void takeView(StayDetailContract.View view);
    }
}