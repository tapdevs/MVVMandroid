package com.tapdevs.myapp.utils;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;


/**
 * Created by  Jan Shair on 18/02/2017.
 */

public class SharedPreferenceUtil {

    private final SharedPreferences preferences;

    public SharedPreferenceUtil(Application application) {
        preferences=PreferenceManager.getDefaultSharedPreferences(application);

    }

    /**
     * Helper method to retrieve a String value from {@link SharedPreferences}.
     *
     
     * @param key
     * @return The value from shared preferences, or null if the value could not be read.
     */
    public  String getStringPreference( String key) {
        String value = null;
        
        if (preferences != null) {
            value = preferences.getString(key, null);
        }
        return value;
    }

    /**
     * Helper method to write a String value to {@link SharedPreferences}.
     *
     
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    public  boolean setStringPreference( String key, String value) {
        
        if (preferences != null && !TextUtils.isEmpty(key)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(key, value);
            return editor.commit();
        }
        return false;
    }

    /**
     * Helper method to retrieve a float value from {@link SharedPreferences}.
     *
     
     * @param key
     * @param defaultValue A default to return if the value could not be read.
     * @return The value from shared preferences, or the provided default.
     */
    public  float getFloatPreference( String key, float defaultValue) {
        float value = defaultValue;
        
        if (preferences != null) {
            value = preferences.getFloat(key, defaultValue);
        }
        return value;
    }

    /**
     * Helper method to write a float value to {@link SharedPreferences}.
     *
     
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    public  boolean setFloatPreference( String key, float value) {
        
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putFloat(key, value);
            return editor.commit();
        }
        return false;
    }

    /**
     * Helper method to retrieve a long value from {@link SharedPreferences}.
     *
     
     * @param key
     * @param defaultValue A default to return if the value could not be read.
     * @return The value from shared preferences, or the provided default.
     */
    public  long getLongPreference( String key, long defaultValue) {
        long value = defaultValue;
        
        if (preferences != null) {
            value = preferences.getLong(key, defaultValue);
        }
        return value;
    }

    /**
     * Helper method to write a long value to {@link SharedPreferences}.
     *
     
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    public  boolean setLongPreference( String key, long value) {
        
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putLong(key, value);
            return editor.commit();
        }
        return false;
    }

    /**
     * Helper method to retrieve an integer value from {@link SharedPreferences}.
     *
     
     * @param key
     * @param defaultValue A default to return if the value could not be read.
     * @return The value from shared preferences, or the provided default.
     */
    public  int getIntegerPreference( String key, int defaultValue) {
        int value = defaultValue;
        
        if (preferences != null) {
            value = preferences.getInt(key, defaultValue);
        }
        return value;
    }

    /**
     * Helper method to write an integer value to {@link SharedPreferences}.
     *
     
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    public  boolean setIntegerPreference( String key, int value) {
        
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(key, value);
            return editor.commit();
        }
        return false;
    }

    /**
     * Helper method to retrieve a boolean value from {@link SharedPreferences}.
     *
     * @param key
     * @param defaultValue A default to return if the value could not be read.
     * @return The value from shared preferences, or the provided default.
     */
    public  boolean getBooleanPreference( String key, boolean defaultValue) {
        boolean value = defaultValue;
        
        if (preferences != null) {
            value = preferences.getBoolean(key, defaultValue);
        }
        return value;
    }

    /**
     * Helper method to write a boolean value to {@link SharedPreferences}.
     *
     * @param key
     * @param value
     * @return true if the new value was successfully written to persistent storage.
     */
    public  boolean setBooleanPreference(String key, boolean value) {
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(key, value);
            return editor.commit();
        }
        return false;
    }
}
