package com.tapdevs.myapp.injections.bindings;

import android.app.Activity;
import android.app.Application;

import com.tapdevs.myapp.injections.component.DaggerNetComponent;
import com.tapdevs.myapp.injections.component.NetComponent;
import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.utils.AppConstants;
import com.tapdevs.myapp.views.fragments.UsersFragment;

/**
 * Created by Jan S. on 23/05/2017.
 */

public class DIBinder {

    public static NetComponent bind(Application application){
        NetComponent mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(application)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule(AppConstants.SERVER_URL))
                .build();
        return mNetComponent;
    }

    public static NetComponent bind(UsersFragment fragment){
        NetComponent mNetComponent = DaggerNetComponent.builder()
                // list of modules that are part of this component need to be created here too
                .appModule(new AppModule(fragment.getActivity().getApplication())) // This also corresponds to the name of your module: %component_name%Module
                .netModule(new NetModule(AppConstants.SERVER_URL))
                .build();
        return mNetComponent;
    }
}
