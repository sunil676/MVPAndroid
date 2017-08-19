package com.sunil.mvp.di.component;

import com.sunil.mvp.di.module.KickStarterDetailModule;
import com.sunil.mvp.di.scope.PerActivity;
import com.sunil.mvp.ui.kiskstarterdetail.KickStarterDetailFragment;

import dagger.Component;

/**
 * Created by sunil on 19-08-2017.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = KickStarterDetailModule.class)
public interface KickStarterDetailComponent {
    void inject(KickStarterDetailFragment kickStarterDetailFragment);
}
