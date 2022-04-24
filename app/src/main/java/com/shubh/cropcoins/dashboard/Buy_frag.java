package com.shubh.cropcoins.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shubh.cropcoins.R;
import com.shubh.cropcoins.buy_adapter;
import com.shubh.cropcoins.databinding.FragmentBuyFragBinding;
import com.shubh.cropcoins.databinding.FragmentSellFragBinding;
import com.shubh.cropcoins.modal_buy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Buy_frag extends Fragment {

    public Buy_frag() {
        // Required empty public constructor
    }

    FragmentBuyFragBinding binding;
    ArrayList<modal_buy> list= new ArrayList<>();
    ArrayList<modal_buy> listKey=new ArrayList<>();
    FirebaseDatabase database;
    buy_adapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding= FragmentBuyFragBinding.inflate(inflater, container, false);

        database = FirebaseDatabase.getInstance();

        adapter= new buy_adapter(list,getContext(),listKey);
        binding.buyRes.setAdapter(adapter);
        binding.buyRes.setLayoutManager(new LinearLayoutManager(getContext()));
        database.getReference().child("AllUserSells").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();

                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    modal_buy adp = snapshot1.getValue(modal_buy.class);
                    list.add(adp);
                }

                listKey.clear();
                for(DataSnapshot snapshot2 : snapshot.getChildren())
                {
                    modal_buy adp= new modal_buy(snapshot2.getKey());
                    listKey.add(adp);
                }


                long seed = System.nanoTime();
                Collections.shuffle(list, new Random(seed));
                Collections.shuffle(listKey, new Random(seed));

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return binding.getRoot();
    }
}