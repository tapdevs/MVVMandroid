package com.tapdevs.myapp.data;

import android.app.Application;
import android.content.Context;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.data.remote.ApiCalls;
import com.tapdevs.myapp.injections.bindings.DIBinder;
import com.tapdevs.myapp.injections.component.DaggerNetComponent;
import com.tapdevs.myapp.injections.modules.AppModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.models.User;
import com.tapdevs.myapp.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

public class DataManager {

    @Inject
    protected ApiCalls apiCalls;
    @Inject protected Scheduler mSubscribeScheduler;


    public DataManager(Application context) {
        injectDependencies(context);
    }

    public DataManager(ApiCalls apiCalls,
                       Scheduler subscribeScheduler) {
        this.apiCalls = apiCalls;
        mSubscribeScheduler = subscribeScheduler;
    }

    protected void injectDependencies(Context context) {
        DIBinder.bind(MyApp.get(context));
    }

    public Scheduler getScheduler() {
        return mSubscribeScheduler;
    }

    public io.reactivex.Observable<List<User>> getUserList() {
        return apiCalls.getUsers();

    }






}
