package com.example.sqlitebasic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {
//    public static final String DATABASE_NAME = "user";
    private static final String TABLE_NAME = "student";
    private static final String ID = "id";
    private static final String NAME = "name";

    public DBManager(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE student ("+"id INTEGER PRIMARY KEY," + "name TEXT NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addStudent(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID,user.getId());
        values.put(NAME, user.getName());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<User> getAllUser() {
        List<User> listUser = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));

                listUser.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listUser;
    }
}
