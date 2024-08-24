package com.motiky.themeui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ImplicitCallActivity extends AppCompatActivity {
    Button dialBtn, messageBtn, emailBtn, shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_implicit_call);

        dialBtn = findViewById(R.id.dialBtn);
        messageBtn = findViewById(R.id.messageBtn);
        emailBtn = findViewById(R.id.emailBtn);
        shareBtn = findViewById(R.id.shareBtn);

        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent iDial = new Intent(Intent.ACTION_DIAL);
                Intent iDial = new Intent();
                iDial.setAction(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: +919065386100"));
                startActivity(iDial);
            }
        });

        messageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMessage= new Intent(Intent.ACTION_SENDTO);
                iMessage.setData(Uri.parse("smsto:" + Uri.encode("+919065386100")));
                iMessage.putExtra("sms_body", "Hello Moti, how are you?");
                startActivity(iMessage);
            }
        });

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rgc822");
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"miitgimy@gmail.com", "motiky00@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Test email");
                iEmail.putExtra(Intent.EXTRA_TEXT, "This is the mail message content");
                startActivity(Intent.createChooser(iEmail, "Please select the mail sender"));
            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT, "Please checkout my portfolio, https://motiky.pythonanywhere.com/");
                startActivity(Intent.createChooser(iShare, "Share via"));
            }
        });

    }
}