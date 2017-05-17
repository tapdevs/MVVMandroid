package com.tapdevs.myapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.tapdevs.myapp.R;

import static com.tapdevs.myapp.utils.SnackBarUtils.showSnackBarOnNoInternet;

/**
 * Created by  Jan Shair on 08/02/2017.
 */

public class NetworkUtils {

    private static boolean checkInternet(Activity context){
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(!(activeNetworkInfo != null && activeNetworkInfo.isConnected())){
            showSnackBarOnNoInternet(context);
            return false;
        }
        return true;
    }


}
