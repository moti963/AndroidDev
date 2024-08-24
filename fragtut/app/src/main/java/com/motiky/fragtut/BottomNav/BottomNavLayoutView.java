package com.motiky.fragtut.BottomNav;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.motiky.fragtut.FragementActivity.AFragment;
import com.motiky.fragtut.FragementActivity.BFragment;
import com.motiky.fragtut.FragementActivity.CFragment;
import com.motiky.fragtut.FragementActivity.DFragment;
import com.motiky.fragtut.FragementActivity.EFragment;
import com.motiky.fragtut.R;

public class BottomNavLayoutView extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bottom_nav_layout_view);

        bottomNav = findViewById(R.id.bottomNav);

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_home) {
                    addNewFragment(new AFragment(), false);
                } else if (id == R.id.nav_search) {
                    addNewFragment(new BFragment(), false);
                } else if (id == R.id.nav_utility) {
                    addNewFragment(new CFragment(), false);
                } else if (id == R.id.nav_contact) {
                    addNewFragment(new DFragment(), false);
                } else {
                    addNewFragment(new EFragment(), true);
                }
                return true;
            }
        });
        bottomNav.setSelectedItemId(R.id.nav_myprofile);
    }

    public void addNewFragment(Fragment fragment, boolean flag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (flag)
            fragmentTransaction.add(R.id.frameCont, fragment);
        else
            fragmentTransaction.replace(R.id.frameCont, fragment);
        fragmentTransaction.commit();
    }
}