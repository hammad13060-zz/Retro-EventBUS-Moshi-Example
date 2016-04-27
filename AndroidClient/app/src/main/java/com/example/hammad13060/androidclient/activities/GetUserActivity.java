package com.example.hammad13060.androidclient.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hammad13060.androidclient.httpHelper.busEvents.GetUserEvent;
import com.example.hammad13060.androidclient.R;
import com.example.hammad13060.androidclient.httpHelper.UsersService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class GetUserActivity extends AppCompatActivity {

    EditText idEditText;
    TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user);

        idEditText = (EditText)findViewById(R.id.id_edit_text);
        responseTextView = (TextView)findViewById(R.id.user_text_view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onGetUserClick(View view) {
        String strID = idEditText.getText().toString();
        try{
            if (!TextUtils.isEmpty(strID)) {
                int id = Integer.parseInt(strID);
                if (id >= 1) {
                    UsersService.getInstance().getUser(id);
                } else {
                    responseTextView.setText("id should be >= 1");
                }
            } else {
                responseTextView.setText("dont leave id field empty. enter a number >= 1");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            responseTextView.setText("please enter id >= 1");
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetUserEvent(GetUserEvent event) {
        if (event.getStatus() == UsersService.STATUS_SUCCESS) {
            responseTextView.setText("full name: " + event.getUser());
        } else {
            responseTextView.setText("GET failed");
        }
    }
}
