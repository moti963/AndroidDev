package com.motiky.mydb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "ContactDB";
    private static final int DB_VERSION = 2;
    private static final String TABLE_NAME = "contacts";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String CONTACT_NO = "contact_no";
    private static final String EMAIL = "email";

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT," + CONTACT_NO + " TEXT," + EMAIL + " TEXT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addNewContact(String name, String contact, String email) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(CONTACT_NO, contact);
        contentValues.put(EMAIL, email);

        db.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<ContactModel> fetchAllContacts () {
        ArrayList<ContactModel> contactData = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        while (cursor.moveToNext()) {
            ContactModel model = new ContactModel();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.contact_no = cursor.getString(2);
            model.email = cursor.getString(3);

            contactData.add(model);
        }
        return contactData;
    }

    public void updateData (ContactModel contactModel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, contactModel.name);
        contentValues.put(CONTACT_NO, contactModel.contact_no);
        contentValues.put(EMAIL, contactModel.email);
        db.update(TABLE_NAME, contentValues, ID + " = " + contactModel.id, null);
    }

    public void deleteData(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME, ID + " = ? ", new String[]{String.valueOf(id)});
    }
}
