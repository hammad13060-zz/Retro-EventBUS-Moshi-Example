package com.example.hammad13060.androidclient.httpHelper.busEvents;

import com.example.hammad13060.androidclient.httpHelper.entities.User;

import java.util.List;

import lombok.Getter;

/**
 * Created by hammad13060 on 27/04/16.
 */
public class GetAllUsersEvent {
    @Getter private int status;
    @Getter private List<User> users;

    public GetAllUsersEvent(int status, List<User> users) {
        this.status = status;
        this.users = users;
    }
}
