package com.shubh.cropcoins.dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shubh.cropcoins.All_stats;
import com.shubh.cropcoins.databinding.FragmentHomeFragBinding;
import com.shubh.cropcoins.wallet_detail;


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

        binding.walletIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext() , wallet_detail.class));
            }
        });


        return binding.getRoot();
    }
}