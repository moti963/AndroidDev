package com.motiky.sensors;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Intent iNext = null;
                switch (position) {
                    case 0:
                        iNext = new Intent(MainActivity.this, AcceleroMeterActivity.class);
                        break;
                    case 1:
                        iNext = new Intent(MainActivity.this, AcceleroMeterActivity.class);
                        break;
                    case 2:
                        iNext = new Intent(MainActivity.this, ProximitySensorActivity.class);
                        break;
                    case 3:
                        iNext = new Intent(MainActivity.this, LightSensorActivity.class);
                        break;
                }
                if (iNext != null) {
                    startActivity(iNext);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}