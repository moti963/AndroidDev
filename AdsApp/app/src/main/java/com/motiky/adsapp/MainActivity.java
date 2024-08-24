package com.motiky.adsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView nav_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nav_bottom = findViewById(R.id.nav_bottom);

        nav_bottom.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                loadNewActivity(id);
                return true;
            }
        });
    }

    public void loadNewActivity(int id) {
        Intent iNext = null;
        if(id == R.id.ne_banner) {
            iNext = new Intent(MainActivity.this, BannerAdActivity.class);
        } else if (id == R.id.ne_interstitial) {
            iNext = new Intent(MainActivity.this, InterstitialAdActivity.class);
        }

        if(iNext != null) {
            startActivity(iNext);
        }
    }
}