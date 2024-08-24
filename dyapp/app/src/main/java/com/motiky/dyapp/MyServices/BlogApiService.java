package com.motiky.dyapp.MyServices;

import com.motiky.dyapp.Models.BlogResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BlogApiService {
    @GET("/blog/blogs/")
    Call<BlogResponse> getBlogs(@Query("page") int page);
}
