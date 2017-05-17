package com.tapdevs.myapp.abstractions;

import android.content.Context;

import org.json.JSONObject;


/**
 * Created by Jan S. on 15/05/2017.
 */

public interface IEvent {
    IEventHandler listen(Context context, String eventName, EventListener listener);
    void post ( Context context, String name);
    void post ( Context context, String name, JSONObject data );
}
