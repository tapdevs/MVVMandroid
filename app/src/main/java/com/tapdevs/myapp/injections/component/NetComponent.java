package com.tapdevs.myapp.injections.component;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.views.activitys.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(Application application);
//    void inject(SplashActivity activity);

    // void inject(MyFragment fragment);
    // void inject(MyService service);

    SharedPreferences provideSharedPreferences();
    Retrofit provideRetrofit();
    DataManager provideDataManager();

}
