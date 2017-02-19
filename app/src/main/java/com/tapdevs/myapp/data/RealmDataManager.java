package com.tapdevs.myapp.data;

import com.tapdevs.myapp.models.User;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by  Jan Shair on 18/02/2017.
 */

public class RealmDataManager {

    private Realm realm;


    public RealmDataManager() {
        initRealm();
    }

    public void saveUserObjects(List<User> objects){

        realm.executeTransaction(realm1 -> realm.copyToRealmOrUpdate(objects));
    }


    public RealmResults<User> getAllUsers(){
        if(realm != null && realm.isClosed()){
            realm=Realm.getDefaultInstance();
        }
        RealmResults<User> results = realm.where(User.class).findAll();
        return results;
    }

    public Realm getRealm() {
        return realm;
    }

    public void initRealm() {
        realm=Realm.getDefaultInstance();

    }

}
