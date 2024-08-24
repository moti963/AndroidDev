package com.motiky.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
    }


    public void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void handleOnClick(View view){
        Button curr_btn = (Button) view;

        if(!curr_btn.getText().toString().isEmpty()){
            return;
        }

        count++;
        String turn = null;
        if(flag == 0){
            curr_btn.setText("X");
            turn = "O";
            flag = 1;
        } else{
            curr_btn.setText("O");
            turn = "X";
            flag = 0;
        }

        if(count > 4){
            b1 = btn1.getText().toString();
            b2 = btn2.getText().toString();
            b3 = btn3.getText().toString();
            b4 = btn4.getText().toString();
            b5 = btn5.getText().toString();
            b6 = btn6.getText().toString();
            b7 = btn7.getText().toString();
            b8 = btn8.getText().toString();
            b9 = btn9.getText().toString();

            String winner = null;

            for (int a = 0; a < 8; a++) {
                String line = null;
                switch (a) {
                    case 0:
                        line = b1 + b2 + b3;
                        break;
                    case 1:
                        line = b4 + b5 + b6;
                        break;
                    case 2:
                        line = b7 + b8 + b9;
                        break;
                    case 3:
                        line = b1 + b4 + b7;
                        break;
                    case 4:
                        line = b2 + b5 + b8;
                        break;
                    case 5:
                        line = b3 + b6 + b9;
                        break;
                    case 6:
                        line = b1 + b5 + b9;
                        break;
                    case 7:
                        line = b3 + b5 + b7;
                        break;
                }

                if(line.equals("XXX")){
                    winner = "X";
                    break;
                } else if(line.equals("OOO")){
                    winner = "O";
                    break;
                }
            }

            if (winner == null) {
                boolean emptySlot = false;
                String move = b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8 + b9;
                if(move.length() != 9){
                    emptySlot = true;
                }
                if (!emptySlot) {
                    winner = "draw";
                }
            }

            if (winner != null) {
                if (winner.equals("draw")) {
                    Toast.makeText(this, "It's a draw! Thanks for playing.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this,"Congratulations! " + winner + " has won! Thanks for playing.", Toast.LENGTH_SHORT).show();
                }
                clearAllButtons();
            }
            /*else {
                Toast.makeText(this, turn + "'s turn; click a button to place " + turn + " in:", Toast.LENGTH_SHORT).show();
            }*/
        }
    }

    private void disableAllButtons(boolean enable){
        btn1.setEnabled(enable);
        btn2.setEnabled(enable);
        btn3.setEnabled(enable);
        btn4.setEnabled(enable);
        btn5.setEnabled(enable);
        btn6.setEnabled(enable);
        btn7.setEnabled(enable);
        btn8.setEnabled(enable);
        btn9.setEnabled(enable);
    }

    private void clearAllButtons(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0;
        flag = 0;
    }

    public void handleRestartButton(View view){
        clearAllButtons();
        Toast.makeText(this, "Game has been restarted.", Toast.LENGTH_SHORT).show();
    }
}