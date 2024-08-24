package com.motiky.themeui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleContactAdapter extends RecyclerView.Adapter<RecycleContactAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactModel> arrContacts;
    int lastPosition = -1;
    public RecycleContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.contactImg.setImageResource(arrContacts.get(position).img);
        holder.nameTxt.setText(arrContacts.get(position).name);
        holder.contactTxt.setText(arrContacts.get(position).contact);

        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_layout);

                EditText editName = dialog.findViewById(R.id.editName);
                EditText editContact = dialog.findViewById(R.id.editContact);
                Button actionBtn = dialog.findViewById(R.id.actionBtn);
                TextView editTitle = dialog.findViewById(R.id.editTitle);
                actionBtn.setText(R.string.update);
                editTitle.setText(R.string.update_contact);

                editName.setText(arrContacts.get(position).name);
                editContact.setText(arrContacts.get(position).contact);

                actionBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "", contact = "";
                        name = editName.getText().toString();
                        if(name.isEmpty()){
                            Toast.makeText(context, "Please enter your name.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        contact = editContact.getText().toString();
                        if(contact.isEmpty()){
                            Toast.makeText(context, "Please enter your contact", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        arrContacts.set(position, new ContactModel(R.drawable.ic_launcher_foreground, name, contact));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context)
                        .setTitle("Delete contact")
                        .setMessage("Are you sure, want to delete?")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrContacts.remove(position);
                                notifyItemRemoved(position);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                alertBuilder.show();
                return false;
            }
        });

        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTxt, contactTxt;
        ImageView contactImg;
        LinearLayout llRow;

        public ViewHolder(View itemView){
            super(itemView);

            nameTxt = itemView.findViewById(R.id.nameTxt);
            contactTxt = itemView.findViewById(R.id.contactTxt);
            contactImg = itemView.findViewById(R.id.contactImg);
            llRow = itemView.findViewById(R.id.llRow);
        }
    }

    private void setAnimation(View viewToAnimate, int position){
        if(position > lastPosition) {
            Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(slideIn);
            lastPosition = position;
        }
    }
}
