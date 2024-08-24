package com.motiky.adsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BannerAdActivity extends AppCompatActivity {

    AdView adView_banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_banner_ad);

        adView_banner = findViewById(R.id.adView_banner);

        MobileAds.initialize(this);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView_banner.loadAd(adRequest);
    }
}