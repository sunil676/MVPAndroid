package com.sunil.mvp.di.module;

import com.sunil.mvp.ui.KickStarterList.KickStarterListContract;
import com.sunil.mvp.ui.KickStarterList.KickStarterListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunil on 19-08-2017.
 */
@Module
public class KickStarterListModule {

    @Provides
    KickStarterListContract.Presenter getKickStarterPresenter() {
        return new KickStarterListPresenter();
    }
}
