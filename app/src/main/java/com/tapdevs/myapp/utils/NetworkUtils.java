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

    public static void showSnackBarOnNoInternet(final Activity context){
        Snackbar snackbar = Snackbar
                .make(context.findViewById(android.R.id.content), context.getString(R.string.noInternet), TSnackbar.LENGTH_LONG)
                .setAction("Connect", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        context.startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS));


                    }
                });

        // Changing message text color
        snackbar.setActionTextColor(Color.RED);

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_signal_wifi_off, 0, 0, 0);
        textView.setCompoundDrawablePadding(context.getResources().getDimensionPixelOffset(R.dimen.snackbar_icon_padding));

        textView.setTextColor(Color.WHITE);

        snackbar.show();
    }
}
