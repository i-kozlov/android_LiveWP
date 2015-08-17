package com.baybaka.lievwp.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.List;

public class SharedPreferenceController {

    private static final String QUANTITY = "quantity";

    private static final String MIN_SPEED = "MIN_SPEED";
    private static final String MAX_SPEED = "MAX_SPEED";

    private static final String MIN_SIZE = "MIN_SIZE";
    private static final String MAX_SIZE = "MAX_SIZE";

    private static final String MIN_ACCEL = "MIN_ACCEL";
    private static final String MAX_ACCEL = "MAX_ACCEL";

    private static final String MIN_LIFE_TIME = "MIN_LIFE_TIME";
    private static final String MAX_LIFE_TIME = "MAX_LIFE_TIME";

    private static SharedPreferenceController instance;
    private final SharedPreferences mPreferences;

    private SharedPreferenceController(Context appContext) {
        mPreferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    public static void init(Context appСontext) {
        if (instance == null) {
            instance = new SharedPreferenceController(appСontext);
        }
    }

    public static SharedPreferenceController getInstance() {
        return instance;
    }

    public int getQuantity() {
        return mPreferences.getInt(QUANTITY, 3);
    }

    public void setQuantity(int val) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putInt(QUANTITY, val);
        editor.apply();
    }

    public float getMinSpeed() {
        return mPreferences.getFloat(MIN_SPEED, 3);
    }

    public float getMaxSpeed() {
        return mPreferences.getFloat(MAX_SPEED, 13);
    }

    public int getMinSize() {
        return mPreferences.getInt(MIN_SIZE, 40);
    }

    public int getMaxSize() {
        return mPreferences.getInt(MAX_SIZE, 70);
    }

    public float getMinAcceleration() {
        return mPreferences.getFloat(MIN_ACCEL, 5);
    }

    public float getMaxAcceleration() {
        return mPreferences.getFloat(MAX_ACCEL, 30);
    }

    public int getMinLifeTime() {
        return mPreferences.getInt(MIN_LIFE_TIME, 3);
    }

    public int getMaxLifeTime() {
        return mPreferences.getInt(MAX_LIFE_TIME, 30);
    }

    public void updateTab2(List<Float> fieldValues) {
        SharedPreferences.Editor editor = mPreferences.edit();

        if (fieldValues.get(0) != null) {
            editor.putFloat(MIN_SPEED, fieldValues.get(0));
        }

        if (fieldValues.get(1) != null) {
            editor.putFloat(MAX_SPEED, fieldValues.get(1));
        }

        if (fieldValues.get(2) != null) {
            editor.putInt(MIN_SIZE, fieldValues.get(2).intValue());
        }

        if (fieldValues.get(3) != null) {
            editor.putInt(MAX_SIZE, fieldValues.get(3).intValue());
        }

        if (fieldValues.get(4) != null) {
            editor.putFloat(MIN_ACCEL, fieldValues.get(4));
        }

        if (fieldValues.get(5) != null) {
            editor.putFloat(MAX_ACCEL, fieldValues.get(5));
        }

        if (fieldValues.get(6) != null) {
            editor.putInt(MIN_LIFE_TIME, fieldValues.get(6).intValue());
        }

        if (fieldValues.get(7) != null) {
            editor.putInt(MAX_LIFE_TIME, fieldValues.get(7).intValue());
        }

        editor.apply();
    }
}
