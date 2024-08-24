package com.motiky.fragtut;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.motiky.fragtut.BottomNav.BottomNavLayoutView;
import com.motiky.fragtut.FragementActivity.AFragment;
import com.motiky.fragtut.FragementActivity.BFragment;
import com.motiky.fragtut.FragementActivity.CFragment;
import com.motiky.fragtut.FragementActivity.DFragment;
import com.motiky.fragtut.NavVewAct.NavMenuActivity;
import com.motiky.fragtut.TutTabLayout.TabLayoutActivity;

public class MainActivity extends AppCompatActivity {

    Button fragaBtn, fragbBtn, fragcBtn, fragdBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        fragaBtn = findViewById(R.id.fragaBtn);
        fragbBtn = findViewById(R.id.fragbBtn);
        fragcBtn = findViewById(R.id.fragcBtn);
        fragdBtn = findViewById(R.id.fragdBtn);

        addNewFragment(new AFragment(), 0);

        fragaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewFragment(new AFragment(), 1);
            }
        });


        fragbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewFragment(new BFragment(), 1);
            }
        });


        fragcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewFragment(new CFragment(), 1);
            }
        });


        fragdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewFragment(new DFragment(), 1);
            }
        });


    }

    public void addNewFragment(Fragment fragment, int flag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(flag == 0)
            fragmentTransaction.add(R.id.container, fragment);
        else
            fragmentTransaction.replace(R.id.container, fragment);

        fragmentTransaction.commit();
    }

    public void moveToTabLayout(View view){
        Intent iNext = new Intent(this, TabLayoutActivity.class);
        startActivity(iNext);
    }

    public void moveToBottomNavigation(View view){
        Intent iNext = new Intent(this, BottomNavLayoutView.class);
        startActivity(iNext);
    }

    public void moveToNavDrawwer(View view){
        Intent iNext = new Intent(this, NavMenuActivity.class);
        startActivity(iNext);
    }
}