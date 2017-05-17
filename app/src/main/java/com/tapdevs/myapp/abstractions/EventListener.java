package com.tapdevs.myapp.abstractions;

import org.json.JSONObject;

/**
 * Created by Jan S. on 15/05/2017.
 */

public abstract class EventListener {
    public abstract void receiveEvent(String eventName, JSONObject data);
}