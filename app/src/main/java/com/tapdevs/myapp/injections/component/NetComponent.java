package com.tapdevs.myapp.injections.component;

import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.views.activitys.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(SplashActivity activity);
    // void inject(MyFragment fragment);
    // void inject(MyService service);
}
