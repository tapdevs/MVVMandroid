package com.tapdevs.myapp.injections.modules;

import android.app.Application;

import com.tapdevs.myapp.views.activitys.MainActivity;
import com.tapdevs.myapp.views.activitys.SplashActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by  Jan Shair on 04/02/2017.
 */
@Module
public class MainActivityModule {

    MainActivity splashActivity;

    public MainActivityModule(MainActivity splashActivity) {
        this.splashActivity = splashActivity;
    }

    @Provides
    @Singleton
    MainActivity providesMainActivity() {
        return new MainActivity();
    }
}
