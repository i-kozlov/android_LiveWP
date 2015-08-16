package com.baybaka.lievwp.android;

import android.app.Application;
import android.content.Context;

import com.baybaka.lievwp.android.utils.SharedPreferenceController;

public class MyApp extends Application {

    public static Context getContext() {
        return context;
    }

    public static boolean isUpdated() {
        return updated;
    }

    public static void setUpdated(boolean updated) {
        MyApp.updated = updated;
    }

    public static boolean updated = false;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        context = getApplicationContext();
        SharedPreferenceController.init(getApplicationContext());
    }
}
