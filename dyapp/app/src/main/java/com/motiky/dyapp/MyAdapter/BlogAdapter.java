package com.motiky.dyapp.MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.motiky.dyapp.Models.Blog;
import com.motiky.dyapp.Models.Tag;
import com.motiky.dyapp.R;

import java.util.List;

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogViewHolder> {

    private final List<Blog> blogList;
    private final Context context;

    public BlogAdapter(Context context, List<Blog> blogList) {
        this.context = context;
        this.blogList = blogList;
    }

    @NonNull
    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the custom layout (card_blog.xml) and create a new ViewHolder
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_layout, parent, false);
        return new BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BlogAdapter.BlogViewHolder holder, int position) {
        Blog blog = blogList.get(position);
        holder.blogTitle.setText(blog.getTitle());
        holder.blogDescription.setText(blog.getDescription());
        holder.blogAuthor.setText("By " + blog.getUsername());
        Glide.with(context).load(blog.getThumbnail()).into(holder.blogThumbnail);

        StringBuilder tags = new StringBuilder();
        for (Tag tag : blog.getTags()) {
            tags.append("#").append(tag.getTag()).append(" ");
        }
        holder.blogTags.setText(tags.toString());
    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        ImageView blogThumbnail;
        TextView blogTitle, blogDescription, blogAuthor, blogTags;

        public BlogViewHolder(@NonNull View itemView) {
            super(itemView);
            blogThumbnail = itemView.findViewById(R.id.blog_thumbnail);
            blogTitle = itemView.findViewById(R.id.blog_title);
            blogDescription = itemView.findViewById(R.id.blog_description);
            blogAuthor = itemView.findViewById(R.id.blog_author);
            blogTags = itemView.findViewById(R.id.blog_tags);
        }
    }
}
