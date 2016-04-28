package com.example.hammad13060.androidclient.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hammad13060.androidclient.R;
import com.example.hammad13060.androidclient.httpHelper.UsersService;
import com.example.hammad13060.androidclient.httpHelper.busEvents.UserEvent;
import com.example.hammad13060.androidclient.httpHelper.entities.User;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class UpdateUserActivity extends AppCompatActivity {

    private EditText idEdiText;
    private EditText firstNameEditText;
    private EditText lastNameEditText;

    private TextView responseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        idEdiText = (EditText)findViewById(R.id.id_edit_text);
        firstNameEditText = (EditText)findViewById(R.id.first_name_edit_text);
        lastNameEditText = (EditText)findViewById(R.id.last_name_edit_text);

        responseTextView = (TextView)findViewById(R.id.response_text_view);
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

    public void onSubmitClick(View view) {
        String strID = idEdiText.getText().toString();
        try {
            int id = Integer.parseInt(strID);
            if (id >= 1) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();

                if (!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName)) {
                    UsersService.getInstance().updateUser(id, new User(firstName, lastName));
                } else {
                    responseTextView.setText("First Name and Last Name fields shouldn't be empty");
                }
            } else {
                responseTextView.setText("id should be >= 1");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            responseTextView.setText("id should be >= 1");
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUserEvent(UserEvent event) {
        if (event.getStatus() == UsersService.STATUS_SUCCESS) {
            responseTextView.setText("updated full name: " + event.getUser());
        } else {
            responseTextView.setText("UPDATE failed");
        }
    }
}
