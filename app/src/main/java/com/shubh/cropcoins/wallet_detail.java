package com.shubh.cropcoins;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shubh.cropcoins.databinding.ActivityWalletDetailBinding;

public class wallet_detail extends AppCompatActivity {

    FirebaseDatabase database;

    FirebaseAuth auth;
    FirebaseUser user;
    Double Coins , After;


    ActivityWalletDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityWalletDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        user  = auth.getCurrentUser();

        database.getReference().child("User").child(user.getUid()).child("Balance").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                binding.balanceCoins.setText(snapshot.getValue(String.class)+" Acoins");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.converterBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database.getReference().child("User").child(user.getUid()).child("Balance").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        Coins = Double.parseDouble(snapshot.getValue(String.class));

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                if(Coins != null )
                {
                    Coins.notify();
                    After = Coins + (Double.parseDouble(binding.currencyConv.getText().toString()))/10;

                    database.getReference().child("User").child(user.getUid()).child("Balance").setValue(Double.toString(After));

                }



            }

        });


    }
}