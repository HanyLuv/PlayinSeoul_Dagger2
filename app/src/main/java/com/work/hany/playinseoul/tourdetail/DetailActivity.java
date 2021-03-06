package com.work.hany.playinseoul.tourdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.work.hany.playinseoul.R;
import com.work.hany.playinseoul.model.ContentType;
import com.work.hany.playinseoul.model.Section;
import com.work.hany.playinseoul.model.dao.TourDetail;
import com.work.hany.playinseoul.network.AreaTour;
import com.work.hany.playinseoul.network.TravelDetail;
import com.work.hany.playinseoul.tourdetail.stay.StayDetailFragment;
import com.work.hany.playinseoul.tourdetail.tour.TourDetailFragment;
import com.work.hany.playinseoul.tourdetail.travel.TravelCourseDetailFragment;
import com.work.hany.playinseoul.util.ActivityUtils;

import javax.inject.Inject;

import dagger.Lazy;
import dagger.android.support.DaggerAppCompatActivity;
import dagger.android.support.DaggerFragment;

public class DetailActivity extends DaggerAppCompatActivity {
    public static final String EXTRA_TOUR_ID = "TOUR_ID";

    @Inject
    AreaTour areaTour;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail);

        ContentType currentTourContentType = ContentType.EMPTY;

        for (ContentType type : ContentType.values()) {
             if (type.getCode() == areaTour.getContentTypeId()) {
                 currentTourContentType = type;
                 break;
             }
        }

        Fragment fragment;

        switch (currentTourContentType) {
            default:
                fragment = new TourDetailFragment();
                Log.e("HANY_TAG"  , "TourDetailFragment id : "+ fragment.getId());
                break;

            case TRAVEL_COURSE:
                fragment = new TravelCourseDetailFragment();
                Log.e("HANY_TAG"  , "TravelCourseDetailFragment id : "+ fragment.getTag());
                break;

            case STAY: //여행코스랑 숙박정보는 디테일인포 결과값이 달라서 일단 각기 다른 fragment로 뺏음
                fragment = new StayDetailFragment();
                Log.e("HANY_TAG"  , "StayDetailFragment id : "+ fragment.getId());
                break;



        }

        if (fragment != null) {
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.fragmentLayout);
        }



    }
}
