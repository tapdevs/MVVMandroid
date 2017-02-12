package com.tapdevs.myapp.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.TextView;

import com.androidadvance.topsnackbar.TSnackbar;
import com.tapdevs.myapp.R;

/**
 * Created by  Jan Shair on 08/02/2017.
 */

public class NetworkUtils {

    public static boolean checkInternet(Activity context){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(!(activeNetworkInfo != null && activeNetworkInfo.isConnected())){
            showSnackBarOnNoInternet(context);
            return false;
        }
        return true;
    }

    public static void showSnackBarOnNoInternet(Activity context){
        TSnackbar snackbar = TSnackbar
                .make(context.findViewById(android.R.id.content), context.getString(R.string.noInternet), TSnackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.WHITE);
        snackbar.setIconLeft(R.drawable.ic_signal_wifi_off, 48); //Size in dp - 24 is great!
//        snackbar.setIconRight(R.drawable.ic_android_green_24dp, 48); //Resize to bigger dp
        snackbar.setIconPadding(8);
        snackbar.setMaxWidth(3000); //if you want fullsize on tablets
        View snackbarView = snackbar.getView();
        snackbarView.setBackgroundColor(Color.BLACK);
        TextView textView = (TextView) snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        snackbar.show();
    }
}
