package com.example.appc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title");
        String studentName = fromAct.getStringExtra("studentName");
        int roll = fromAct.getIntExtra("roll", 0);

        TextView studentInfo;

        studentInfo = findViewById(R.id.studentInfo);

        studentInfo.setText("Name : " + studentName + " Roll No : " + roll);
        //Objects.requireNonNull(getSupportActionBar()).setTitle(title);
    }
}
