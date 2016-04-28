package com.example.hammad13060.androidclient.httpHelper.busEvents;

import com.example.hammad13060.androidclient.httpHelper.entities.User;

import lombok.Getter;

/**
 * Created by hammad13060 on 28/04/16.
 */
public class UserEvent {
    @Getter private int status;
    @Getter private User user;

    public UserEvent(int status, User user) {
        this.status = status;
        this.user = user;
    }
}
