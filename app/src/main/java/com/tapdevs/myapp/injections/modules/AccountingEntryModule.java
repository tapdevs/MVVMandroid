package com.tapdevs.myapp.injections.modules;

import com.tapdevs.myapp.models.AccountingEntry;
import com.tapdevs.myapp.models.DebitOrCredit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by  Jan Shair on 30/01/2017.
 */

@Module
public class AccountingEntryModule {

    @Provides
    @Singleton
    DebitOrCredit provideMotor(){
        return new DebitOrCredit();
    }

    @Provides @Singleton
    AccountingEntry provideVehicle(){
        return new AccountingEntry(new DebitOrCredit());
    }
}
