package com.sunil.mvp.di.module;

import android.app.Application;

import com.sunil.mvp.MainApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunil on 19-08-2017.
 */

@Module
public class ApplicationModule {

    private final MainApplication mainApplication;

    public ApplicationModule(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    @Provides
    public Application provideApplication() {
        return mainApplication;
    }


   /* @Provides
    SharedPreferences provideSharedPrefs() {
        return mainApplication.getSharedPreferences("dragger-prefs", Context.MODE_PRIVATE);
    }*/
}
