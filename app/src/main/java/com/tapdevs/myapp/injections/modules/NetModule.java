package com.tapdevs.myapp.injections.modules;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.data.remote.ApiCalls;
import com.tapdevs.myapp.data.remote.RetrofitHelper;
import com.tapdevs.myapp.data.RealmDataManager;
import com.tapdevs.myapp.utils.SharedPreferenceUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

@Module
public class NetModule {

    String mBaseUrl;

    // Constructor needs one parameter to instantiate.
    public NetModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    // Application reference must come from ApplicationModule.class
    SharedPreferenceUtil providesSharedPreferences(Application application) {
        return new SharedPreferenceUtil(application);
    }

    @Provides
    @Singleton
        // Application reference must come from ApplicationModule.class
    RealmDataManager providesRealm(Application application) {
        return new RealmDataManager();
    }
    @Provides
    @Singleton
    Cache provideOkHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder().cache(cache).build();
    }

    @Provides
    @Singleton
    ApiCalls provideApiInterface(Application application) {

        return new RetrofitHelper().newApiCalls();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(Application application){
        return new DataManager(provideApiInterface(application), provideSubscribeScheduler());
    }

    @Provides
    @Singleton
    Scheduler provideSubscribeScheduler() {
        return Schedulers.io();
    }
}
