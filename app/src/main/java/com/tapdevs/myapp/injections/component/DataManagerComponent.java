package com.tapdevs.myapp.injections.component;

import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.injections.modules.DataManagerModule;
import com.tapdevs.myapp.injections.modules.NetModule;
import com.tapdevs.myapp.injections.scope.PerDataManager;

import dagger.Component;

@PerDataManager
@Component(dependencies = NetComponent.class, modules = NetModule.class)
public interface DataManagerComponent {

    void inject(DataManager dataManager);
}