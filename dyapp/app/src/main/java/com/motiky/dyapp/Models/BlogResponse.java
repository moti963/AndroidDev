package com.motiky.dyapp.Models;
import java.util.List;

public class BlogResponse {
    private int count;
    private String next;
    private String previous;
    private List<Blog> results;

    // Getters
    public int getCount() { return count; }
    public String getNext() { return next; }
    public String getPrevious() { return previous; }
    public List<Blog> getResults() { return results; }
}
