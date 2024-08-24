package com.motiky.themeui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Toolbar mytoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mytoolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(mytoolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("MyApp");
        }
        mytoolbar.setSubtitle("Myapp Subtitle");
    }

    public void handleOnClick(View view){
        Intent iNext = new Intent(this, CardView.class);
        startActivity(iNext);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.nav_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.opt_new) {
            Toast.makeText(this, "Create new file", Toast.LENGTH_SHORT).show();
        } else if(itemId == R.id.opt_open){
            Toast.makeText(this, "Open file", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.opt_save) {
            Toast.makeText(this, "Save file", Toast.LENGTH_SHORT).show();
        } else if (itemId == android.R.id.home){
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void handleOnClickToastButton(View v){
        Toast toast = new Toast(getApplicationContext());
        View view = getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup)findViewById(R.id.toastViewCont));
        toast.setView(view);

        TextView message_txt = view.findViewById(R.id.message_txt);
        message_txt.setText("Jay Ho !!");
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    public void moveToDialogPage(View view){
        Intent iDialogPage = new Intent(this, AlertDialogActivity.class);
        startActivity(iDialogPage);
    }

    public void moveToImplicitActivity(View view){
        Intent implicitIntent = new Intent(this, ImplicitCallActivity.class);
        startActivity(implicitIntent);
    }
}