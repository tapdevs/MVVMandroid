package com.tapdevs.myapp.data.receivers;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import com.tapdevs.myapp.abstractions.IEventHandler;

/**
 * Created by Jan S. on 17/05/2017.
 */

public class EventHandler implements IEventHandler {

    private LocalBroadcastManager broadcastManager;
    private BroadcastReceiver reciever;
    private String name;

    public EventHandler ( String name, LocalBroadcastManager broadcastManager, BroadcastReceiver reciever )
    {
        this.name = name;
        this.broadcastManager = broadcastManager;
        this.reciever = reciever;

        this.register();
    }

    public void close ( ) {
        this.unregister();
    }

    private void register ( ) {
        broadcastManager.registerReceiver(this.reciever, new IntentFilter(this.name));
    }

    private void unregister ( ) {
        broadcastManager.unregisterReceiver(this.reciever);
    }
}
