package com.motiky.roomlib;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense")
public class Expense {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "amount")
    private float amount;

    // Constructor used by Room
    public Expense(int id, String title, float amount) {
        this.id = id;
        this.title = title;
        this.amount = amount;
    }

    // Constructor with @Ignore annotation to be used for custom instantiation
    @Ignore
    public Expense(String title, float amount) {
        this.title = title;
        this.amount = amount;
    }

    // Getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
