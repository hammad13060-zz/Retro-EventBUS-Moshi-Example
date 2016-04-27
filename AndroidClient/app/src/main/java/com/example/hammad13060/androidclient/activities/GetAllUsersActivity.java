package com.example.hammad13060.androidclient.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hammad13060.androidclient.httpHelper.busEvents.GetAllUsersEvent;
import com.example.hammad13060.androidclient.R;
import com.example.hammad13060.androidclient.httpHelper.entities.User;
import com.example.hammad13060.androidclient.httpHelper.UsersService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class GetAllUsersActivity extends AppCompatActivity {

    TextView usersTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_all_users);

        usersTextView = (TextView)findViewById(R.id.users_text_view);
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        UsersService.getInstance().getAllUsers();
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetAllUsersEvent(GetAllUsersEvent event) {
        if (event.getStatus() == UsersService.STATUS_SUCCESS) {
            StringBuilder output = new StringBuilder("");
            List<User> users = event.getUsers();
            for (int i = 0; i < users.size(); i++) {
                output.append("\nfull name: " + users.get(i));
            }
            usersTextView.setText(output.toString());
        } else {
            usersTextView.setText("GET failed");
        }
    }
}
