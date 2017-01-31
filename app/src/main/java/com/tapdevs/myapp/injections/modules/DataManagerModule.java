package com.tapdevs.myapp.injections.modules;

import com.tapdevs.myapp.data.remote.ApiCalls;
import com.tapdevs.myapp.data.remote.RetrofitHelper;
import com.tapdevs.myapp.injections.scope.PerDataManager;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

@Module
public class DataManagerModule {

    public DataManagerModule() {

    }

    @Provides
    @PerDataManager
    ApiCalls provideHackerNewsService() {
        return new RetrofitHelper().newHackerNewsService();
    }

    @Provides
    @PerDataManager
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }
}
