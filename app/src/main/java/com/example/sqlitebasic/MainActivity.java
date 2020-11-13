package com.example.sqlitebasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvUser;
    ArrayList<User> users;
    CustomAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        userAdapter = new CustomAdapter(this, R.layout.list_student, users);
        lvUser.setAdapter(userAdapter);

//        DBManager dbManager = new DBManager(this, "userdb.db", null, 1);
//        dbManager.addStudent(new User(1, "Nguyen Ngoc Thoai"));
    }

    public void mapping() {
        lvUser.findViewById(R.id.listview);
        DBManager dbManager = new DBManager(this, "userdb.db", null, 1);
        dbManager.addStudent(new User(1, "Nguyen Ngoc Thoai"));
        dbManager.addStudent(new User(2, "Nguyen Ngoc Thanh"));
        dbManager.addStudent(new User(3, "Nguyen Thanh Hoai"));
        dbManager.addStudent(new User(4, "Nguyen Van An"));
        dbManager.addStudent(new User(5, "Nguyen Tran Quang Tu"));
        dbManager.addStudent(new User(6, "Nguyen Thien An"));
        dbManager.addStudent(new User(7, "Ly Nha Ky"));

        users= (ArrayList<User>) dbManager.getAllUser();
    }
}