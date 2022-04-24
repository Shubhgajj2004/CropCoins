package com.shubh.cropcoins.dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shubh.cropcoins.All_stats;
import com.shubh.cropcoins.R;
import com.shubh.cropcoins.databinding.FragmentBuyFragBinding;
import com.shubh.cropcoins.databinding.FragmentHomeFragBinding;


public class Home_frag extends Fragment {


    public Home_frag() {
        // Required empty public constructor
    }

    FragmentHomeFragBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding= FragmentHomeFragBinding.inflate(inflater, container, false);


        binding.sampleAffair2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext() , All_stats.class));
            }
        });


        return binding.getRoot();
    }
}