package com.tapdevs.myapp.views.activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.injections.component.NetComponent;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.models.User;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import timber.log.Timber;

import static android.os.Build.VERSION_CODES.N;

public class SplashActivity extends AppCompatActivity {

    private SplashActivity context;
    private final long timeOut=5000;

    @Inject SharedPreferences sharedPreferences;
    @Inject DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context=this;
        ((MyApp)getApplicationContext()).inject();
        sharedPreferences=((MyApp)getApplicationContext()).getNetComponent().provideSharedPreferences();
        dataManager=MyApp.get(context).getNetComponent().provideDataManager();
        Timber.d("Timber setup");
//        Observable<List<User>> users=dataManager.getUsers();


//        Timber.d(users.toString());
            if(sharedPreferences == null){
                Timber.d("Splash","null accounting entry");
            }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(context,MainActivity.class));
            }
        },timeOut);
    }
}
