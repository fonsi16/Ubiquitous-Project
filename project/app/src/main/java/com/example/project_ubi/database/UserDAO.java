package com.example.project_ubi.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.example.project_ubi.model.User;

public class UserDAO {

    private SQLiteDatabase db;

    public UserDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public long addUser(User user){
        ContentValues cv=new ContentValues();
        return 0;
    }
}
