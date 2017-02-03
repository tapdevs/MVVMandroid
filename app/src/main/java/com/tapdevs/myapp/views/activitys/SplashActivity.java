package com.tapdevs.myapp.views.activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tapdevs.myapp.R;
import com.tapdevs.myapp.injections.component.AccountingEntryComponent;
import com.tapdevs.myapp.injections.modules.AccountingEntryModule;
import com.tapdevs.myapp.models.AccountingEntry;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity {

    @Inject AccountingEntry accountingEntry;
    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


//        AccountingEntryComponent component = DaggerAccountingEntryComponent.builder().accountingEntryModule(new AccountingEntryModule()).build();

//        accountingEntry = component.provideVehicle();
            if(sharedPreferences == null){
                Log.d("Splash","null accounting entry");
            }
//        Toast.makeText(this, String.valueOf(accountingEntry.getDebitOrCredit().getDescription()), Toast.LENGTH_SHORT).show();

        startActivity(new Intent(this,MainActivity.class));
    }
}
