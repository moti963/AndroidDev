package com.motiky.dyapp.MyActivity;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.motiky.dyapp.Models.Blog;
import com.motiky.dyapp.Models.BlogResponse;
import com.motiky.dyapp.MyAdapter.BlogAdapter;
import com.motiky.dyapp.MyServices.BlogApiService;
import com.motiky.dyapp.databinding.ActivityBlogPageBinding;
import com.motiky.dyapp.R;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BlogPageActivity extends AppCompatActivity {

    private ActivityBlogPageBinding binding;
    private RecyclerView recyclerView;
    private BlogAdapter blogAdapter;
    private List<Blog> blogList = new ArrayList<>();

    private Retrofit retrofit;
    private BlogApiService apiService;

    private boolean isLoading = false;
    private int currentPage = 1;
    private int totalPages = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBlogPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retrofit = new Retrofit.Builder()
                .baseUrl("https://connectsphere.pythonanywhere.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(BlogApiService.class);
        blogAdapter = new BlogAdapter(this, blogList);
        recyclerView.setAdapter(blogAdapter);

        loadBlogs(currentPage);

        // Set up the endless scroll listener
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (!isLoading && layoutManager != null && layoutManager.findLastCompletelyVisibleItemPosition() == blogList.size() - 1) {
                    if (currentPage < totalPages) {
                        loadBlogs(++currentPage);
                    }
                }
            }
        });
    }

    private void loadBlogs(int page) {
        isLoading = true;
        Call<BlogResponse> call = apiService.getBlogs(page);
        call.enqueue(new Callback<BlogResponse>() {
            @Override
            public void onResponse(Call<BlogResponse> call, Response<BlogResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    BlogResponse blogResponse = response.body();
                    blogList.addAll(blogResponse.getResults());
                    blogAdapter.notifyDataSetChanged();
                    totalPages = (int) Math.ceil(blogResponse.getCount() / 10.0); // Assuming 10 blogs per page
                } else {
                    Log.e("API Error", "Response failed");
                }
                isLoading = false;
            }

            @Override
            public void onFailure(Call<BlogResponse> call, Throwable throwable) {
                Log.e("API Error", "Request failed: " + throwable.getMessage());
                isLoading = false;
            }
        });
    }
}
