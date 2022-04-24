package com.shubh.cropcoins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.shubh.cropcoins.loginFragments.Loginadapter;

public class LoginAct extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 vpager2;
    FirebaseAuth auth;
    View ellipse2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout=findViewById(R.id.TabLayout);
        vpager2=findViewById(R.id.Viewpag2);
        ellipse2=findViewById(R.id.ellipse_2);
        auth=FirebaseAuth.getInstance();


        getSupportActionBar().hide();



        FragmentManager fm= getSupportFragmentManager();
        Loginadapter loginadapter=new Loginadapter(fm,getLifecycle());
        vpager2.setAdapter(loginadapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vpager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }

    public void onStart() {

        super.onStart();

        FirebaseUser user= auth.getCurrentUser();

        if(user!=null)
        {
            startActivity(new Intent(getApplicationContext(),Dashboard.class));
            finish();
        }
    }
}