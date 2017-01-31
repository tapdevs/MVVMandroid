package com.tapdevs.myapp.views.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tapdevs.myapp.R;
import com.tapdevs.myapp.injections.component.AccountingEntryComponent;
import com.tapdevs.myapp.injections.component.DaggerAccountingEntryComponent;
import com.tapdevs.myapp.injections.modules.AccountingEntryModule;
import com.tapdevs.myapp.models.AccountingEntry;

public class SplashActivity extends AppCompatActivity {

    AccountingEntry accountingEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        AccountingEntryComponent component = DaggerAccountingEntryComponent.builder().accountingEntryModule(new AccountingEntryModule()).build();

        accountingEntry = component.provideVehicle();

        Toast.makeText(this, String.valueOf(accountingEntry.getDebitOrCredit().getDescription()), Toast.LENGTH_SHORT).show();
    }
}
