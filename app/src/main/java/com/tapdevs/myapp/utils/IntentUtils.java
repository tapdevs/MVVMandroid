package com.tapdevs.myapp.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by  Jan Shair on 16/02/2017.
 */

public class IntentUtils {

    public static void connectToWifi(Context context){
        context.startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS));
    }
}
