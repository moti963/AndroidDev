package com.motiky.dyapp.MyActivity;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.motiky.dyapp.Models.User;
import com.motiky.dyapp.MyServices.UserInfoApiService;
import com.motiky.dyapp.R;
import com.motiky.dyapp.databinding.ActivityUserInfoBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserInfoActivity extends AppCompatActivity {

    private ActivityUserInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUserInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });


        String base_url = "https://jsonplaceholder.typicode.com/users/";

        TextView main_content = findViewById(R.id.main_content);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserInfoApiService userInfoApiService = retrofit.create(UserInfoApiService.class);
        Call<List<User>> call = userInfoApiService.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful() && response.body() != null){
                    List<User> users = response.body();
                    StringBuilder userInfo = new StringBuilder();
                    for(User user : users) {
                        userInfo.append("ID: ").append(user.getId()).append("\n");
                        userInfo.append("Name: ").append(user.getName()).append("\n");
                        userInfo.append("Username: ").append(user.getUsername()).append("\n");
                        userInfo.append("Email: ").append(user.getEmail()).append("\n");
                        userInfo.append("Address: ").append(user.getAddress().getStreet()).append(", ")
                                .append(user.getAddress().getSuite()).append(", ")
                                .append(user.getAddress().getCity()).append(", ")
                                .append(user.getAddress().getZipcode()).append("\n");
                        userInfo.append("Geo: Lat ").append(user.getAddress().getGeo().getLat())
                                .append(", Lng ").append(user.getAddress().getGeo().getLng()).append("\n");
                        userInfo.append("Phone: ").append(user.getPhone()).append("\n");
                        userInfo.append("Website: ").append(user.getWebsite()).append("\n");
                        userInfo.append("Company: ").append(user.getCompany().getName()).append("\n\n");
                    }
                    main_content.setText(userInfo.toString());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {
                Log.e("API Error", "Request failed : " + throwable.getMessage());
            }
        });
    }
}