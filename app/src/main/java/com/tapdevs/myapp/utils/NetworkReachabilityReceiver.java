package com.tapdevs.myapp.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.tapdevs.myapp.abstractions.IEvent;
import com.tapdevs.myapp.abstractions.NetworkStatus;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Jan S. on 15/05/2017.
 */


public class NetworkReachabilityReceiver extends BroadcastReceiver {

    public final static String networkChangeRecieverOnRecieve = "networkChangeRecieverOnRecieve";
    public final static String networkStatusKey = "networkStatus";
    private IEvent event;

    public NetworkReachabilityReceiver() {
    }

    public void setEvent(IEvent event) {
        this.event = event;
    }



    public NetworkStatus getReachability(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        AppConstants.networkStatus  = NetworkStatus.networkStatusNotReachable;

        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) {
                if (networkInfo.isConnected() && networkInfo.isAvailable()) {
                    if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                        AppConstants.networkStatus  = NetworkStatus.networkStatusReachableViaWiFi;
                    } else if (networkInfo.getType() == ConnectivityManager.TYPE_WIMAX || networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                        AppConstants.networkStatus  = NetworkStatus.networkStatusReachableViaWWAN;
                    } else {
                        AppConstants.networkStatus  = NetworkStatus.networkStatusReachableViaWWAN;
                    }
                }
            }
        }
        return AppConstants.networkStatus;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {

        NetworkStatus reachability = getReachability(context);
        JSONObject data = new JSONObject();
        try {
            data.putOpt(networkStatusKey, reachability.toString());
        } catch (JSONException exception) {

        }

        if(event != null) {
            event.post(context, networkChangeRecieverOnRecieve, data);
        }
    }
}