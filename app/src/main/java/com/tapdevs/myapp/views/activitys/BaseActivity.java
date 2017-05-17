package com.tapdevs.myapp.views.activitys;

import android.app.FragmentManager;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.abstractions.EventListener;
import com.tapdevs.myapp.abstractions.IEvent;
import com.tapdevs.myapp.abstractions.IEventHandler;
import com.tapdevs.myapp.abstractions.NetworkStatus;
import com.tapdevs.myapp.data.receivers.Event;
import com.tapdevs.myapp.models.User;
import com.tapdevs.myapp.utils.NetworkReachabilityReceiver;
import com.tapdevs.myapp.utils.SnackBarUtils;
import com.tapdevs.myapp.views.fragments.BaseFragment;


import org.json.JSONObject;

import java.util.List;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    protected BaseActivity context;
    private NetworkReachabilityReceiver networkReachabilityReceiver;
    private IEventHandler networkReachabilityListner;
    private IEvent event;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        injectDependencies();
        injectViews();
        registerNetworkReachabilityListners();
    }



    /**
     * Create a new Dagger ObjectGraph to add new dependencies using a plus operation and inject the
     * declared one in the activity. This new graph will be destroyed once the activity lifecycle
     * finish.
     *
     * This is the key of how to use Activity scope dependency injection.
     */
    public abstract void injectDependencies() ;

    /**
     * Replace every field annotated with ButterKnife annotations like @InjectView with the proper
     * value.
     */
    private void injectViews() {
        ButterKnife.bind(this);
    }

    /**
     * Options items selected
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                } else {
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void registerNetworkReachabilityListners() {
        event=new Event();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        networkReachabilityReceiver = new NetworkReachabilityReceiver();
        networkReachabilityReceiver.setEvent(event);
        registerReceiver(networkReachabilityReceiver, filter);

        this.networkReachabilityListner = event.listen(this, NetworkReachabilityReceiver.networkChangeRecieverOnRecieve, new EventListener() {
            @Override
            public void receiveEvent(String eventName, JSONObject data) {
                String networkStatus = (String) data.opt(NetworkReachabilityReceiver.networkStatusKey);
                String networkNotReachableStatus = NetworkStatus.networkStatusNotReachable.toString();

                if (networkStatus.equals(networkNotReachableStatus)) {
                    SnackBarUtils.showSnackBarOnNoInternet(context);
                }
            }
        });
    }

    private void unregisterNetworkReachabilityListners() {
        if (networkReachabilityListner != null) {
            networkReachabilityListner.close();
            networkReachabilityListner = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterNetworkReachabilityListners();
    }
}
