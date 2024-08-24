package com.motiky.bmiapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText body_htf, body_hti, body_wt;
        AppCompatButton calc_btn;
        TextView bmi_result;
        LinearLayout main_comp;

        body_htf = findViewById(R.id.body_htf);
        body_hti = findViewById(R.id.body_hti);
        body_wt = findViewById(R.id.body_wt);
        calc_btn = findViewById(R.id.calc_btn);
        bmi_result = findViewById(R.id.bmi_result);
        main_comp = findViewById(R.id.main);

        calc_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                double wt = Double.parseDouble(body_wt.getText().toString());
                double height_ft = Double.parseDouble(body_htf.getText().toString());
                double height_in = Double.parseDouble(body_hti.getText().toString());

                double total_in = (height_ft * 12.0) + height_in;
                double height_mt = total_in * 0.0254;
                double bmi = calculateBMI(height_mt, wt);

                String bmi_category = "";
                if(bmi < 18.5){
                    bmi_category = "Under weight";
                    main_comp.setBackgroundColor(getResources().getColor(R.color.underweight));
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    bmi_category =  "Normal weight";
                    main_comp.setBackgroundColor(getResources().getColor(R.color.normal_weight));
                } else if (bmi >= 24.9 && bmi < 30) {
                    bmi_category = "Over weight";
                    main_comp.setBackgroundColor(getResources().getColor(R.color.overweight));
                }else {
                    bmi_category = "Obesity";
                    main_comp.setBackgroundColor(getResources().getColor(R.color.obese));
                }

                bmi_result.setText("Your BMI is " + bmi + ", which is consider under "+ bmi_category);
            }
        });
    }

    public static double calculateBMI(double height, double weight){
        if(height <= 0 || weight <= 0) return 0.0;
        return weight / (height * height);
    }
}
