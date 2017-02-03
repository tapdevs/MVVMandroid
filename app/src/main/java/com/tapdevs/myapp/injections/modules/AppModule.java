package com.tapdevs.myapp.injections.modules;

import android.app.Application;

import com.tapdevs.myapp.views.activitys.SplashActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

@Module
public class AppModule {

    Application mApplication;
    SplashActivity splashActivity;

    public AppModule(Application application) {
        mApplication = application;
    }
    public AppModule(SplashActivity splashActivity) {
        this.splashActivity = splashActivity;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    SplashActivity providesSplashActivity() {
        return new SplashActivity();
    }
}
