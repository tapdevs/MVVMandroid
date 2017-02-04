package com.tapdevs.myapp.injections.component;

import android.app.Application;
import android.content.SharedPreferences;

import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.injections.modules.MainActivityModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.views.activitys.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by  Jan Shair on 04/02/2017.
 */

@Singleton
@Component(modules={MainActivityModule.class})
public interface MainActivityComponent {
    void inject(MainActivity activity);
//    void inject(SplashActivity activity);

    // void inject(MyFragment fragment);
    // void inject(MyService service);

//    SharedPreferences provideSharedPreferences();
//    Retrofit provideRetrofit();
}
