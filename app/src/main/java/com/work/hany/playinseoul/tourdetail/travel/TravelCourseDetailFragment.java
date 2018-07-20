package com.work.hany.playinseoul.tourdetail.travel;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.work.hany.playinseoul.R;
import com.work.hany.playinseoul.di.ActivityScoped;
import com.work.hany.playinseoul.model.Section;
import com.work.hany.playinseoul.network.AreaTour;
import com.work.hany.playinseoul.network.TravelDetail;
import com.work.hany.playinseoul.network.TravelIntro;
import com.work.hany.playinseoul.tourdetail.adapter.TravelCourseDetailRecyclerViewAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

@ActivityScoped
public class TravelCourseDetailFragment extends DaggerFragment implements TravelCourseDetailContract.View {

    @Inject
    TravelCourseDetailContract.Presenter presenter;

    @Inject
    AreaTour areaTour;

    private TravelCourseDetailRecyclerViewAdapter detailRecyclerViewAdapter;

    @Inject
    public TravelCourseDetailFragment(){}

    @Override
    public void onResume() {
        super.onResume();
        presenter.takeView(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Section> sections = new ArrayList<>();

        Section imageSection = new Section(Section.ItemType.IMAGE, areaTour.getLargeImage());
        Section overheadSection = new Section(Section.ItemType.OVERHEAD, areaTour);
        Section informationSection = new Section(Section.ItemType.INFORMATION, null);

        sections.add(imageSection);
        sections.add(overheadSection);
        sections.add(informationSection);

        detailRecyclerViewAdapter = new TravelCourseDetailRecyclerViewAdapter(sections);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail,null,false);

        RecyclerView detailTourRecyclerView = rootView.findViewById(R.id.tour_detail_recycler_view);
        detailTourRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        detailTourRecyclerView.setAdapter(detailRecyclerViewAdapter);

        presenter.loadTravelCourseDetail(areaTour.getContentId(), areaTour.getContentTypeId());

        return rootView;
    }

    @Override
    public void initTourDetailUi(ArrayList<TravelDetail> travelDetails) {
        for (TravelDetail detail : travelDetails ){
            detailRecyclerViewAdapter.addSection(Section.ItemType.DETAIL, detail);
        }
    }

    @Override
    public void initTourOverviewUi(AreaTour areaTour) { /** 해당 여행 설명*/
        areaTour.setMediumCategoryCode(this.areaTour.getMediumCategoryCode());
        detailRecyclerViewAdapter.updateSection(Section.ItemType.OVERHEAD, areaTour);
    }

    @Override
    public void initTourIntroUi(TravelIntro information) {
        detailRecyclerViewAdapter.updateSection(Section.ItemType.INFORMATION, information);
    }

}
