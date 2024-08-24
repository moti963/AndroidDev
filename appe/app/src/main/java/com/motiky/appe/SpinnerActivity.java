package com.motiky.appe;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {
    TextView name_text_view;
    Spinner spinnerView;
    ArrayList<String> rollIds = new ArrayList<>();
    AutoCompleteTextView actView;
    ArrayList<String> arrLangs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_spinner);

        Intent intent = getIntent();

        String personName = intent.getStringExtra("personName");

        name_text_view = findViewById(R.id.name_text_view);
        name_text_view.setText(personName);

        spinnerView = findViewById(R.id.spinnerView);
        actView = findViewById(R.id.actView);

        addData();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, rollIds);
        spinnerView.setAdapter(adapter);

        addLanguageData();

        ArrayAdapter<String> actAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrLangs);
        actView.setAdapter(actAdapter);
        actView.setThreshold(1);
    }

    public void addData(){

        for(int i = 1; i <= 20; i++){
            if(i < 10)
               rollIds.add("20BTECH0" + i);
            else
                rollIds.add("20BTECH" + i);
        }
    }

    public void addLanguageData(){
        arrLangs.add("Hindi");
        arrLangs.add("English");
        arrLangs.add("Bhojpuri");
        arrLangs.add("Maithali");
        arrLangs.add("Spanish");
        arrLangs.add("German");
        arrLangs.add("Angika");
        arrLangs.add("Bangala");
        arrLangs.add("Devnagari");
    }
}