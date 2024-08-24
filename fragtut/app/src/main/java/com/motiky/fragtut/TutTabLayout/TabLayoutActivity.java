package com.motiky.fragtut.TutTabLayout;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.motiky.fragtut.R;
import com.motiky.fragtut.TutViewPager.ViewPagerAdapter;

public class TabLayoutActivity extends AppCompatActivity {

    TabLayout tabContainer;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tab_layout);

        tabContainer = findViewById(R.id.tabContainer);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        tabContainer.setupWithViewPager(viewPager);

    }
}