package com.tapdevs.myapp.injections.component;

import com.tapdevs.myapp.data.DataManager;
import com.tapdevs.myapp.injections.modules.DataManagerModule;
import com.tapdevs.myapp.injections.scope.PerDataManager;

import dagger.Component;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

@PerDataManager
@Component(dependencies = ApplicationComponent.class, modules = DataManagerModule.class)
public interface DataManagerComponent {

    void inject(DataManager dataManager);
}
