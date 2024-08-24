package com.motiky.dyapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.motiky.dyapp.MyActivity.BlogPageActivity;
import com.motiky.dyapp.MyActivity.UserInfoActivity;
import com.motiky.dyapp.MyActivity.WebViewActivity;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView main_bottom_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        main_bottom_nav = findViewById(R.id.bottom_nav);
        main_bottom_nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                handleNavigation(item.getItemId());
                return true;
            }
        });
        main_bottom_nav.setSelectedItemId(R.id.home);
    }

    public void handleNavigation(int itemId) {
        Intent intent = null;
        if (itemId == R.id.user_info) {
            intent = new Intent(MainActivity.this, UserInfoActivity.class);
        } else if (itemId == R.id.blog_page) {
            intent = new Intent(MainActivity.this, BlogPageActivity.class);
        } else if (itemId == R.id.webview_page) {
            intent = new Intent(MainActivity.this, WebViewActivity.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }

    public void moveToUserInfoActivity(View view){
        Intent iNext = new Intent(this, UserInfoActivity.class);
        startActivity(iNext);
    }

    public void moveToBlogPageActivity(View view){
        Intent iNext = new Intent(this, BlogPageActivity.class);
        startActivity(iNext);
    }
}