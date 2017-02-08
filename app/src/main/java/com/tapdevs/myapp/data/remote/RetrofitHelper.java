package com.tapdevs.myapp.data.remote;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.tapdevs.myapp.utils.AppConstants;

import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.realm.rx.RxObservableFactory;
import retrofit.RxJavaCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by  Jan Shair on 31/01/2017.
 */

public class RetrofitHelper {

    public ApiCalls newApiCalls() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.SERVER_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiCalls.class);
    }
}
