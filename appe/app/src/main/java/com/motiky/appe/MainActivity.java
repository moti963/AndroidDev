package com.motiky.appe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView laView;
    ListView listView;
    ArrayList<String> arrNames = new ArrayList<>();
    int[] arrNos = new int[]{1, 2, 3, 4, 5, 6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

/*        laView.setAnimation(R.raw.lottie);
        laView.playAnimation();
        laView.loop(true);*/

        listView = findViewById(R.id.listView);

        arrNames.add("Moti");
        arrNames.add("Vasu");
        arrNames.add("Vidya");
        arrNames.add("Divya");
        arrNames.add("Anand");
        arrNames.add("Rupesh");
        arrNames.add("Moti");
        arrNames.add("Vasu");
        arrNames.add("Vidya");
        arrNames.add("Divya");
        arrNames.add("Anand");
        arrNames.add("Rupesh");
        arrNames.add("Moti");
        arrNames.add("Vasu");
        arrNames.add("Vidya");
        arrNames.add("Divya");
        arrNames.add("Anand");
        arrNames.add("Rupesh");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrNames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, "Clicked on " + arrNames.get(position), Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Clicked on the list view.", Toast.LENGTH_SHORT).show();
                        break;
                }

                Intent iSpinner = new Intent(MainActivity.this, SpinnerActivity.class);
                iSpinner.putExtra("personName", arrNames.get(position));
                startActivity(iSpinner);
            }
        });
    }
}