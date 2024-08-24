package com.motiky.themeui;

import android.app.Dialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecycleView extends AppCompatActivity {

    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    RecyclerView recyclerContact;
    FloatingActionButton btnOpenDialog;
    RecycleContactAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);

        recyclerContact = findViewById(R.id.recyclerContact);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        recyclerContact.setLayoutManager(new LinearLayoutManager(this));
        addContactData();
        adapter = new RecycleContactAdapter(this, arrContacts);
        recyclerContact.setAdapter(adapter);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(RecycleView.this);
                dialog.setContentView(R.layout.add_update_layout);

                EditText editName = dialog.findViewById(R.id.editName);
                EditText editContact = dialog.findViewById(R.id.editContact);
                Button actionBtn = dialog.findViewById(R.id.actionBtn);

                actionBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "", contact = "";
                        name = editName.getText().toString();
                        if(name.isEmpty()) {
                            Toast.makeText(RecycleView.this, "Please, enter your name.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        contact = editContact.getText().toString();
                        if (contact.isEmpty()){
                            Toast.makeText(RecycleView.this, "Please, enter your contact.", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        arrContacts.add(new ContactModel(R.drawable.my, name, contact));
                        adapter.notifyItemInserted(arrContacts.size() - 1);
                        recyclerContact.scrollToPosition(arrContacts.size() - 1);
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    public void addContactData(){
        ContactModel modela = new ContactModel(R.drawable.a, "Alice", "9876543201");
        ContactModel modelb = new ContactModel(R.drawable.b, "Bob", "9876543202");
        ContactModel modelc = new ContactModel(R.drawable.c, "Jack", "9876543203");
        ContactModel modeld = new ContactModel(R.drawable.d, "Zohn", "9876543204");
        ContactModel modele = new ContactModel(R.drawable.e, "Emma", "9876543205");
        ContactModel modelf = new ContactModel(R.drawable.f, "Harry", "9876543206");
        ContactModel modelg = new ContactModel(R.drawable.g, "Kanika", "9876543207");
        ContactModel modelh = new ContactModel(R.drawable.h, "Tony", "9876543208");
        ContactModel modeli = new ContactModel(R.drawable.i, "Thor", "9876543209");
        ContactModel modelj = new ContactModel(R.drawable.j, "Nikki", "9876543210");

        arrContacts.add(modela);
        arrContacts.add(modelb);
        arrContacts.add(modelc);
        arrContacts.add(modeld);
        arrContacts.add(modele);
        arrContacts.add(modelf);
        arrContacts.add(modelg);
        arrContacts.add(modelh);
        arrContacts.add(modeli);
        arrContacts.add(modelj);
        arrContacts.add(modela);
        arrContacts.add(modelb);
        arrContacts.add(modelc);
        arrContacts.add(modeld);
        arrContacts.add(modele);
        arrContacts.add(modelf);
        arrContacts.add(modelg);
        arrContacts.add(modelh);
        arrContacts.add(modeli);
        arrContacts.add(modelj);
    }
}
