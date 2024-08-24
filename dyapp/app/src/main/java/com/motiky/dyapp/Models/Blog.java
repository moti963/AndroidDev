package com.motiky.dyapp.Models;
import java.util.List;

public class Blog {
    private String id;
    private int user;
    private String username;
    private String profile_img;
    private String title;
    private String thumbnail;
    private String description;
    private List<Tag> tags;
    private int views;
    private String created_at;

    // Getters
    public String getId() { return id; }
    public int getUser() { return user; }
    public String getUsername() { return username; }
    public String getProfileImg() { return profile_img; }
    public String getTitle() { return title; }
    public String getThumbnail() { return thumbnail; }
    public String getDescription() { return description; }
    public List<Tag> getTags() { return tags; }
    public int getViews() { return views; }
    public String getCreatedAt() { return created_at; }
}
