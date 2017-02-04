package com.tapdevs.myapp.views.activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tapdevs.myapp.MyApp;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.injections.component.AccountingEntryComponent;
import com.tapdevs.myapp.injections.modules.AccountingEntryModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.models.AccountingEntry;

import javax.inject.Inject;

import retrofit2.Retrofit;
import timber.log.Timber;

import static android.os.Build.VERSION_CODES.N;

public class SplashActivity extends AppCompatActivity {

    private SplashActivity context;

    @Inject AccountingEntry accountingEntry;
    @Inject
    SharedPreferences sharedPreferences;
    @Inject Retrofit retrofit;
    @Inject DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context=this;
        sharedPreferences=((MyApp)getApplicationContext()).getNetComponent().provideSharedPreferences();
        retrofit=MyApp.get(context).getNetComponent().provideRetrofit();
        dataManager=MyApp.get(context).getNetComponent().provideDataManager();
        Timber.d("Timber setup");

//        AccountingEntryComponent component = DaggerAccountingEntryComponent.builder().accountingEntryModule(new AccountingEntryModule()).build();

//        accountingEntry = component.provideVehicle();
            if(sharedPreferences == null){
                Log.d("Splash","null accounting entry");
            }
//        Toast.makeText(this, String.valueOf(accountingEntry.getDebitOrCredit().getDescription()), Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this,MainActivity.class));
    }
}
