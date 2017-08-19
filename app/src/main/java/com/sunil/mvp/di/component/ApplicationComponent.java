package com.sunil.mvp.di.component;

import android.app.Application;

import com.sunil.mvp.MainApplication;
import com.sunil.mvp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sunil on 19-08-2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MainApplication mainApplication);

    Application getApplication();

}
