package com.example.hammad13060.androidclient.httpHelper.busEvents;

import lombok.Getter;

/**
 * Created by hammad13060 on 28/04/16.
 */
public class DeleteUserEvent {
    @Getter private int status;

    public DeleteUserEvent(int status) {
        this.status = status;
    }
}
