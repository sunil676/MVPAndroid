package com.sunil.mvp.di.component;

import com.sunil.mvp.MainActivity;
import com.sunil.mvp.di.module.ActivityModule;
import com.sunil.mvp.di.scope.PerActivity;


import dagger.Component;

/**
 * Created by sunil on 19-08-2017.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}