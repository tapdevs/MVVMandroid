package com.tapdevs.myapp;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.tapdevs.myapp.injections.bindings.DIBinder;
import com.tapdevs.myapp.injections.component.DaggerNetComponent;
import com.tapdevs.myapp.injections.component.NetComponent;
import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.utils.AppConstants;
import com.tapdevs.myapp.utils.CrashlyticsTree;


import io.realm.Realm;
import timber.log.Timber;

/**
 * Created by  Jan Shair on 30/01/2017.
 */

public class MyApp extends Application {
    private NetComponent mNetComponent;
//    ApplicationComponent mApplicationComponent;



    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        mNetComponent = DIBinder.bind(this);

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree()); else     Timber.plant(new CrashlyticsTree());
        Realm.init(this);

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }

    public void inject(){
        getNetComponent().inject(this);
    }

    public static MyApp get(Context context) {
        return (MyApp) context.getApplicationContext();
    }

}
