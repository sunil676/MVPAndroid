package com.sunil.mvp.di.component;

import com.sunil.mvp.di.module.KickStarterListModule;
import com.sunil.mvp.di.scope.PerActivity;
import com.sunil.mvp.ui.KickStarterList.KickStarterListFragment;

import dagger.Component;

/**
 * Created by sunil on 19-08-2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = KickStarterListModule.class)
public interface KickStarterListComponent {
    void inject(KickStarterListFragment kickStarterListFragment);
}

