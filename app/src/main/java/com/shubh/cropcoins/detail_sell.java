package com.shubh.cropcoins;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shubh.cropcoins.databinding.ActivityDetailSellBinding;

import java.util.ArrayList;

public class detail_sell extends AppCompatActivity {

    FirebaseDatabase database;
    FirebaseAuth auth;
    FirebaseUser user;
    ActivityDetailSellBinding binding;

    ArrayList<String> parent_list = new ArrayList<>() ;
    ArrayAdapter<String> adp_parent ;

    ArrayList<String> Grain , pulses , oil_crops;
    ArrayAdapter<String> childAdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailSellBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        database = FirebaseDatabase.getInstance();
        auth= FirebaseAuth.getInstance();
        user = auth.getCurrentUser();



        parent_list.add("Grain");
        parent_list.add("pulses");
        parent_list.add("Oil Crops");

        adp_parent = new ArrayAdapter<>(getApplicationContext() , android.R.layout.simple_spinner_item , parent_list);

        binding.parentSell.setAdapter(adp_parent);


        Grain = new ArrayList<>();
        Grain.add("Whole wheat");
        Grain.add("Wheat");
        Grain.add("Wheat berries");
        Grain.add("Buckwheat");
        Grain.add("Sunflower seeds");
        Grain.add("oats");
        Grain.add("Barley");
        Grain.add("Brown rice");
        Grain.add("Rye");
        Grain.add("Millet");
        Grain.add("Amranth");
        Grain.add("Corn");
        Grain.add("Flaxseed");
        Grain.add("Rice");
        Grain.add("Sesame seed");


        pulses = new ArrayList<>();

        pulses.add("Dry beans");
        pulses.add("Lentils");
        pulses.add("Dry peas");
        pulses.add("Cow peas");
        pulses.add("Chick peas");
        pulses.add("Pigeon peas");


        oil_crops = new ArrayList<>();

        oil_crops.add("Cotton");
        oil_crops.add("Sunflower");
        oil_crops.add("Castor");
        oil_crops.add("Peanut");
        oil_crops.add("Sesame");


        binding.parentSell.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0)
                {
                    childAdp = new ArrayAdapter<>(getApplicationContext() , android.R.layout.simple_spinner_item , Grain);
                }
                if (position == 1)
                {
                    childAdp = new ArrayAdapter<>(getApplicationContext() , android.R.layout.simple_spinner_item , pulses);

                }
                if(position == 2)
                {
                    childAdp = new ArrayAdapter<>(getApplicationContext() , android.R.layout.simple_spinner_item , oil_crops);

                }

                binding.childSell.setAdapter(childAdp);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







        binding.SubmitSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.progressBar.setVisibility(View.VISIBLE);

               DatabaseReference reference = database.getReference().child("User").child(user.getUid()).child("Sells").push();

               reference.child("Item").setValue(binding.childSell.getSelectedItem().toString());
               reference.child("Load").setValue(binding.weightSell.getText().toString());
               reference.child("State").setValue("Pending");
               reference.child("Original").setValue(binding.MinBidSell.getText().toString());
               reference.child("Minbid").setValue(binding.MinBidSell.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void unused) {

                       database.getReference().child("User").child(user.getUid()).child("Name").addValueEventListener(new ValueEventListener() {
                           @Override
                           public void onDataChange(@NonNull DataSnapshot snapshot) {

                               DatabaseReference reference1 = database.getReference().child("AllUserSells").child(reference.getKey());
                               reference1.child("Seller").setValue(snapshot.getValue(String.class));
                               reference1.child("Item").setValue(binding.childSell.getSelectedItem().toString());
                               reference1.child("Original").setValue(binding.MinBidSell.getText().toString());
                               reference1.child("Load").setValue(binding.weightSell.getText().toString());
                               reference1.child("Minbid").setValue(binding.MinBidSell.getText().toString());
                           }

                           @Override
                           public void onCancelled(@NonNull DatabaseError error) {

                           }
                       });

                   }
               }).addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void unused) {
                       binding.progressBar.setVisibility(View.GONE);
                       binding.processCheck.setText("Submitted");
                       binding.processCheck.setVisibility(View.VISIBLE);

                   }
               }).addOnSuccessListener(new OnSuccessListener<Void>() {
                   @Override
                   public void onSuccess(Void unused) {

                       startActivity(new Intent(getApplicationContext(), Dashboard.class));
                   }
               });


            }
        });


    }
}