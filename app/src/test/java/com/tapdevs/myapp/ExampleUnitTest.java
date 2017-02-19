package com.tapdevs.myapp;

import com.tapdevs.myapp.data.RealmDataManager;
import com.tapdevs.myapp.utils.TextCheckers;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(TextCheckers.isEmailValid("name@email.com"));
        assertFalse(TextCheckers.isEmailValid("name.pl"));
        assertFalse(TextCheckers.isEmailValid("name..com"));
        assertFalse(TextCheckers.isEmailValid("name@e212"));
        assertTrue(TextCheckers.isEmailValid("namads34534e@emafsdfdsil.io"));




    }

    @Test
    public void TestRealmUsers(){
//        Realm.init(InstrumentationRegistry.getTargetContext());
        RealmDataManager realmDataManager = new RealmDataManager();
        realmDataManager.getAllUsers();
    }
}