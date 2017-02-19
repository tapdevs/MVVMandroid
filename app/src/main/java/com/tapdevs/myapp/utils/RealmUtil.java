package com.tapdevs.myapp.utils;

import com.tapdevs.myapp.models.User;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by  Jan Shair on 18/02/2017.
 */

public class RealmUtil {

    private Realm realm;


    public RealmUtil() {
        realm=Realm.getDefaultInstance();
    }

    public void saveUserObjects(List<User> objects){

        realm.executeTransaction(realm1 -> executeRealmTransaction(objects));
    }

    public void executeRealmTransaction(List<User> objects){
        realm.copyToRealmOrUpdate(objects);
    }

    public RealmResults<User> getAllUsers(){
        RealmResults<User> results = realm.where(User.class).findAll();
        return results;
    }

    public Realm getRealm() {
        return realm;
    }
}
