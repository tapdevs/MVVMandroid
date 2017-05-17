package com.tapdevs.myapp.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.tapdevs.myapp.R;

/**
 * Created by  Jan Shair on 16/02/2017.
 */

public class SnackBarUtils {

    private Activity context;

    public SnackBarUtils(Activity context) {
        this.context=context;
    }

    public Snackbar getSnackBarForNoInternet(){
        Snackbar snackbar = Snackbar
                .make(context.findViewById(android.R.id.content), context.getString(R.string.noInternet), Snackbar.LENGTH_INDEFINITE)
                .setAction("Connect", v -> IntentUtils.connectToWifi(context));

        // Changing message text color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            snackbar.setActionTextColor(context.getColor(R.color.colorAccent));
        }else {
            snackbar.setActionTextColor(context.getResources().getColor(R.color.colorAccent));
        }

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_signal_wifi_off, 0, 0, 0);
        textView.setCompoundDrawablePadding(context.getResources().getDimensionPixelOffset(R.dimen.snackbar_icon_padding));

        textView.setTextColor(Color.WHITE);

        snackbar.show();
        return snackbar;
    }
}
