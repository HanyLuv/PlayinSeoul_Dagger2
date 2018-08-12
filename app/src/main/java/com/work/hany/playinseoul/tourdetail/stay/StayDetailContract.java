package com.work.hany.playinseoul.tourdetail.stay;

import com.work.hany.playinseoul.BaseView;
import com.work.hany.playinseoul.model.dao.StayDetail;
import com.work.hany.playinseoul.model.dao.TourIntro;
import com.work.hany.playinseoul.network.AreaTour;
import com.work.hany.playinseoul.network.TourPhoto;
import com.work.hany.playinseoul.tourdetail.BaseDetailContract;

import java.util.ArrayList;

public interface StayDetailContract {

    interface View extends BaseDetailContract.BaseDetailView {
        //        void initTourOverviewUi(AreaTour areaTour);
        void initTourOverviewUi(AreaTour areaTour);

        void initTourIntroUi(TourIntro information);

        void initTourDetailUi(ArrayList<StayDetail> stayDetails);

        void initTourPhotosUi(ArrayList<TourPhoto> photos); //TODO 음... 음식때도 이거호출할텐데 이름변경생각해보자

    }

    interface Presenter extends BaseDetailContract.BaseDetailPresenter {
        void loadContent(int contentId, int contentTypeId);

    }
}
