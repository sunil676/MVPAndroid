package com.sunil.mvp.di.module;

import com.sunil.mvp.ui.kiskstarterdetail.KickStarterDetailContract;
import com.sunil.mvp.ui.kiskstarterdetail.KickStarterDetailPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunil on 19-08-2017.
 */
@Module
public class KickStarterDetailModule {

    @Provides
    public KickStarterDetailContract.Presenter getKickStarterDetailPresenter(){
        return new KickStarterDetailPresenter();
    }
}
