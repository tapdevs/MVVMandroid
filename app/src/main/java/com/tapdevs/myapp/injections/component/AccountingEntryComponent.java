package com.tapdevs.myapp.injections.component;

import com.tapdevs.myapp.injections.modules.AccountingEntryModule;
import com.tapdevs.myapp.models.AccountingEntry;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by  Jan Shair on 30/01/2017.
 */



@Singleton
@Component(modules = {AccountingEntryModule.class})
public interface AccountingEntryComponent {

    AccountingEntry provideVehicle();

}