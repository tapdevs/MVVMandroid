package com.tapdevs.myapp.injections.component;

import android.app.Application;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.data.remote.ApiCalls;
import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.models.User;
import com.tapdevs.myapp.utils.RealmUtil;
import com.tapdevs.myapp.utils.SharedPreferenceUtil;
import com.tapdevs.myapp.views.activitys.BaseActivity;
import com.tapdevs.myapp.views.activitys.MainActivity;
import com.tapdevs.myapp.views.activitys.SplashActivity;
import com.tapdevs.myapp.views.fragments.BaseFragment;
import com.tapdevs.myapp.views.fragments.UsersFragment;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;
import retrofit2.Retrofit;

import static android.R.attr.fragment;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
     void inject(Application application);
     void inject(MainActivity activity);

     void inject(UsersFragment fragment);

    SharedPreferenceUtil provideSharedPreferences();
    RealmUtil providesRealm();
    DataManager provideDataManager();

}
