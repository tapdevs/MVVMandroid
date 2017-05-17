package com.tapdevs.myapp.data.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.tapdevs.myapp.abstractions.EventListener;
import com.tapdevs.myapp.abstractions.IEvent;
import com.tapdevs.myapp.abstractions.IEventHandler;

import org.json.JSONException;
import org.json.JSONObject;

public class Event implements IEvent {
    private static final String dataExtra = "data";

    public void post(Context context, String name) {
        post(context, name, new JSONObject());
    }

    public void post(Context context, String name, JSONObject data) {
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(context);
        Intent intent = new Intent(name);
        if (data == null) {
            data = new JSONObject();
        }
        intent.putExtra(dataExtra, data.toString());
        broadcastManager.sendBroadcast(intent);
    }

    public IEventHandler listen(Context context, final String name, final EventListener listener) {
        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(context);
        return new EventHandler(name, broadcastManager, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                JSONObject data;
                try {
                    data = new JSONObject(intent.getStringExtra(dataExtra));
                } catch (JSONException exception) {
                    data = new JSONObject();
                }
                listener.receiveEvent(name, data);
            }
        });
    }
}