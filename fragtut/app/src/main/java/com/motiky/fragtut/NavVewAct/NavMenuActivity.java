package com.motiky.fragtut.NavVewAct;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.motiky.fragtut.FragementActivity.AFragment;
import com.motiky.fragtut.FragementActivity.BFragment;
import com.motiky.fragtut.FragementActivity.CFragment;
import com.motiky.fragtut.FragementActivity.DFragment;
import com.motiky.fragtut.FragementActivity.EFragment;
import com.motiky.fragtut.R;

public class NavMenuActivity extends AppCompatActivity {
    DrawerLayout drawwer_main;
    Toolbar drawwer_toolbar;
    NavigationView navbar_view;
    FrameLayout dc_container;
    String ROOT_FRAGMENT_TAG = "home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nav_menu);

        drawwer_main = findViewById(R.id.drawwer_main);
        drawwer_toolbar = findViewById(R.id.drawwer_toolbar);
        navbar_view = findViewById(R.id.navbar_view);

        // STEP-1
        setSupportActionBar(drawwer_toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawwer_main, drawwer_toolbar, R.string.open_drawwer, R.string.close_drawwer);
        drawwer_main.addDrawerListener(toggle);
        toggle.syncState();

        navbar_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                
                if(id == R.id.nav_home){
                    addNewFragmentLayout(new AFragment(), true);
                } else if (id == R.id.nav_search) {
                    addNewFragmentLayout(new BFragment(), false);
                } else if (id == R.id.nav_utility) {
                    addNewFragmentLayout(new CFragment(), false);
                } else if (id == R.id.nav_contact) {
                    addNewFragmentLayout(new DFragment(), false);
                } else {
                    addNewFragmentLayout(new EFragment(), false);
                }
                drawwer_main.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawwer_main.isDrawerOpen(GravityCompat.START)){
            drawwer_main.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void addNewFragmentLayout(Fragment fragment, boolean flag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(flag) {
            fragmentTransaction.add(R.id.dc_container, fragment);
            fragmentManager.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fragmentTransaction.addToBackStack((ROOT_FRAGMENT_TAG));
        }
        else {
            fragmentTransaction.replace(R.id.dc_container, fragment);
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }
}