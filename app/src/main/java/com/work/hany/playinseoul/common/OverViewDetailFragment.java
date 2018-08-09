package com.work.hany.playinseoul.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.work.hany.playinseoul.R;
import com.work.hany.playinseoul.di.FragmentScoped;
import com.work.hany.playinseoul.network.AreaTour;
import com.work.hany.playinseoul.tourdetail.OverViewModule;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Component;
import dagger.Subcomponent;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.DaggerFragment;
public class OverViewDetailFragment extends DaggerFragment implements OverViewDetailContract.View {
    public static final String ARGUMENT_TOUR = "ARGUMENT_TOUR";
    public static final String BUNDLE_TOUR = "BUNDLE_TOUR";

    @Inject
    @Named("OverViewDetailFragment")
    AreaTour areaTour;

    @Inject
    public OverViewDetailFragment(){ }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();
//        presenter.takeView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_overview, null, false);

        TextView contentTextView = rootView.findViewById(R.id.over_view_content_text_view);
        TextView titleTextView = rootView.findViewById(R.id.over_view_title_text_view);
        SpannableString spannableOverViewString = new SpannableString(Html.fromHtml(areaTour.getOverview()));
        String overViewString = spannableOverViewString.toString();

        contentTextView.setText(overViewString);
        titleTextView.setText(areaTour.getContentTitle());
        return rootView;
    }
}
