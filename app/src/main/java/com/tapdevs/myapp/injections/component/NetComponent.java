package com.tapdevs.myapp.injections.component;

import android.app.Application;

import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.injections.scope.PerDataManager;
import com.tapdevs.myapp.utils.SharedPreferenceUtil;
import com.tapdevs.myapp.views.activitys.MainActivity;
import com.tapdevs.myapp.views.fragments.GamesListFragment;
import com.tapdevs.myapp.views.fragments.PlayerInfoFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

@PerDataManager
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
     void inject(Application application);
     void inject(GamesListFragment fragment);
     void inject(PlayerInfoFragment fragment);

    SharedPreferenceUtil provideSharedPreferences();
    DataManager provideDataManager();

}
