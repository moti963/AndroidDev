package com.motiky.dyapp.MyServices;

import com.motiky.dyapp.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserInfoApiService {
    @GET("/users")
    Call<List<User>> getUsers();
}
