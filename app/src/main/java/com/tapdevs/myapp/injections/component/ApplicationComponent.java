package com.tapdevs.myapp.injections.component;

import android.app.Application;


import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.views.activitys.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface ApplicationComponent {

    void inject(MainActivity mainActivity);

    Application application();
    DataManager dataManager();
}