package com.tapdevs.myapp.utils;

import com.tapdevs.myapp.models.User;

import io.realm.Realm;

/**
 * Created by  Jan Shair on 18/02/2017.
 */

public class RealmUtil {

    private Realm realm;


    public RealmUtil() {
        realm=Realm.getDefaultInstance();
    }

    public void saveUserObject(User object){
        User userObject= realm.createObject(User.class);
        userObject=object;
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

            }

        });
    }

    public Realm getRealm() {
        return realm;
    }
}
