package com.instant.hritvik.smaf;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class ChartFragment extends Fragment {
    Button followers;
    Button following;
    Button like;
    Button post;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chart, container, false);
        followers = v.findViewById(R.id.follwers_bar_chart_btn);
        following = v.findViewById(R.id.following_bar_chart_btn);
        like = v.findViewById(R.id.like_bar_chart_btn);
        post = v.findViewById(R.id.post_bar_chart_btn);
        followers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), followingchartActivity.class));
            }

        });

        return v;
    }


}

