package com.shubh.cropcoins;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shubh.cropcoins.databinding.ActivityDetailBuyBinding;
import com.shubh.cropcoins.databinding.FragmentBuyFragBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Detail_buy extends AppCompatActivity {

    FirebaseDatabase database;
    FirebaseAuth auth;
    FirebaseUser user;
    ActivityDetailBuyBinding binding;


    ArrayList<modal_pybuy> list= new ArrayList<>();


    adapter_Pybuy adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailBuyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();


        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        binding.typeBuy2.setText(getIntent().getStringExtra("type"));
        binding.sellerBuy2.setText(getIntent().getStringExtra("seller"));
        binding.originalBuy2.setText(getIntent().getStringExtra("original"));
        binding.loadBuy2.setText(getIntent().getStringExtra("amount")+"Kg");

        binding.BuyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database.getReference().child("AllUserSells").child(getIntent().getStringExtra("key")).child("Minbid").setValue(binding.AuctionPriceBuy.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(getApplicationContext(), "Bought Succesfully", Toast.LENGTH_SHORT).show();
                    }
                });



                database.getReference().child("User").child(user.getUid()).child("Name").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                        DatabaseReference reference =  database.getReference().child("AllUserSells").child(getIntent().getStringExtra("key")).child("Buyer").push();

                        reference.child("Buyer").setValue(snapshot.getValue(String.class));
                        reference.child("Bid").setValue(binding.AuctionPriceBuy.getText().toString());


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



            }
        });


        adapter= new adapter_Pybuy(list,getApplicationContext());
        binding.PYAuctionRes.setAdapter(adapter);
        binding.PYAuctionRes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        database.getReference().child("AllUserSells").child(getIntent().getStringExtra("key")).child("Buyer").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();

                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    modal_pybuy adp = snapshot1.getValue(modal_pybuy.class);
                    list.add(adp);
                }


                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






    }


}