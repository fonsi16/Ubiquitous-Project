package com.example.project_ubi.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.project_ubi.model.User;

public class DAO {

    private SQLiteDatabase db;

    public DAO(SQLiteDatabase db) {
        this.db = db;
    }

    public long addUser(User user){
        ContentValues values=new ContentValues();
        values.put(DatabaseHelper.COLUMN_USER_NAME, user.getName());
    }
}
