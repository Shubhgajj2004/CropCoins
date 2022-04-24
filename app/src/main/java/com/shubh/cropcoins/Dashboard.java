package com.shubh.cropcoins;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.shubh.cropcoins.dashboard.Buy_frag;
import com.shubh.cropcoins.dashboard.Home_frag;
import com.shubh.cropcoins.dashboard.Profile_frag;
import com.shubh.cropcoins.dashboard.Sell_frag;
import com.shubh.cropcoins.databinding.ActivityDashboardBinding;

public class Dashboard extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.navView.setItemIconTintList(null);
        getSupportActionBar().hide();

        binding.navView.setOnItemSelectedListener(this);

        Fragment frag=new Home_frag();
        getSupportFragmentManager().beginTransaction().replace(R.id.Dashboard_Frame,frag).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId())
        {
            case R.id.Home:
                fragment=new Home_frag();
                break;

            case R.id.All_Items:
                fragment=new Sell_frag();
                break;

            case R.id.Orders:
                fragment=new Buy_frag();
                break;

            case R.id.Profile:
                fragment=new Profile_frag();
                break;




        }


        getSupportFragmentManager().beginTransaction().replace(R.id.Dashboard_Frame,fragment).commit();




        return true;
    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder builder=new AlertDialog.Builder(Dashboard.this);
        builder.setMessage("Are you sure you want to exit ?");
        builder.setTitle("Exit");
        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog dialog= builder.create();
        dialog.show();

    }
}