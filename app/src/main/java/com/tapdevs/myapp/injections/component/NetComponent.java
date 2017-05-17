package com.tapdevs.myapp.injections.component;

import android.app.Application;

import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.utils.SharedPreferenceUtil;
import com.tapdevs.myapp.views.activitys.MainActivity;
import com.tapdevs.myapp.views.fragments.UsersFragment;

import javax.inject.Singleton;

import dagger.Component;

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
    DataManager provideDataManager();

}
