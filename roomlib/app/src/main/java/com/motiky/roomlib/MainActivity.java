package com.motiky.roomlib;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText exp_title, exp_amount;
    Button exp_add;
    TextView cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        exp_title = findViewById(R.id.exp_title);
        exp_amount = findViewById(R.id.exp_amount);
        exp_add = findViewById(R.id.exp_add);
        cont = findViewById(R.id.cont);

        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);

        exp_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title =  exp_title.getText().toString();
                String amountText = exp_amount.getText().toString().trim();
                float amount = 0;

                if(title.isEmpty()){
                    Toast.makeText(MainActivity.this, "Title can't be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (amountText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter an amount", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    amount = Float.parseFloat(amountText);
                }

                databaseHelper.expenseDAO().addExpense(
                        new Expense(title, amount)
                );
                exp_title.setText("");
                exp_amount.setText("");

                ArrayList<Expense> arrExp = (ArrayList<Expense>) databaseHelper.expenseDAO().getAllExpense();
                StringBuilder txt = new StringBuilder();
                for(int i=0; i < arrExp.size(); i++) {
                    Expense exp = arrExp.get(i);
                    String data = "Id : " + exp.getId() + "\n"
                            + "Title : " + exp.getTitle() + "\n"
                            + "Amount : " + exp.getAmount() + "\n\n";
                    txt.append(data);
                }
                cont.setText(txt);
            }
        });
    }
}