package com.shubh.cropcoins.dashboard;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shubh.cropcoins.R;
import com.shubh.cropcoins.databinding.FragmentSellFragBinding;
import com.shubh.cropcoins.detail_sell;

public class Sell_frag extends Fragment {


    public Sell_frag() {
        // Required empty public constructor
    }

    FragmentSellFragBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding= FragmentSellFragBinding.inflate(inflater, container, false);


        binding.sellBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext() , detail_sell.class));
            }
        });

        return binding.getRoot();
    }
}