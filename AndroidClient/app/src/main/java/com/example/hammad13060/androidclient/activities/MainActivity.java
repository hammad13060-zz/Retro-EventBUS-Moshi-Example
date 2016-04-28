package com.example.hammad13060.androidclient.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hammad13060.androidclient.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
    }

    public void onAddUserClick(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void onGetAllUsersClick(View view) {
        Intent intent = new Intent(this, GetAllUsersActivity.class);
        startActivity(intent);
    }

    public void onGetUserClick(View view) {
        Intent intent = new Intent(this, GetUserActivity.class);
        startActivity(intent);
    }

    public  void onUpdateUserClick(View view) {
        Intent intent = new Intent(this, UpdateUserActivity.class);
        startActivity(intent);
    }

    public void onDeleteUserClick(View view) {
        Intent intent = new Intent(this, DeleteUserActivity.class);
        startActivity(intent);
    }
}
