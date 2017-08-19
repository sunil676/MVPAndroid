package com.sunil.mvp.ui.KickStarterList;

import android.support.annotation.NonNull;

import com.google.common.base.Preconditions;
import com.sunil.mvp.api.APIService;
import com.sunil.mvp.api.apiModel.KickStarterModel;
import com.sunil.mvp.db.model.KickStarter;
import com.sunil.mvp.db.source.KickStarterLocalSource;

import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by sunil on 12-08-2017.
 */

public class KickStarterListPresenter implements KickStarterListContract.Presenter {

    @NonNull
    private KickStarterListContract.View mKickStartView;

    private CompositeDisposable mCompositeDisposable;

    private KickStarterLocalSource mKickStarterLocalDataSource;

    public KickStarterListPresenter( ) {
        mKickStarterLocalDataSource = new KickStarterLocalSource();
    }

    @Override
    public void subscribe() {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
    }

    @Override
    public void unSubscribe() {
        mCompositeDisposable.clear();
    }

    @Override
    public void attachView(KickStarterListContract.View view) {
        mKickStartView = view;
    }


    @Override
    public void loadKickStartersAPI() {

        final Flowable<List<KickStarterModel>> listFlowable = APIService.Creator.newApiClient().getKickStarters();
        listFlowable .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull Subscription subscription) throws Exception {

            }
        }).subscribe(new Consumer<List<KickStarterModel>>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull List<KickStarterModel> kickStarters) throws Exception {
               // save into db
                for (int index =0; index < kickStarters.size(); index++) {
                    KickStarterModel model = kickStarters.get(index);
                    KickStarter kickStarter = new KickStarter();
                    kickStarter.setS_no(model.getSNo().toString());
                    kickStarter.setAmt_pledged(model.getAmtPledged()+"");
                    kickStarter.setBlurb(model.getBlurb());
                    kickStarter.setBy(model.getBy());
                    kickStarter.setCountry(model.getCountry());
                    kickStarter.setCurrency(model.getCurrency());
                    kickStarter.setEnd_time(model.getEndTime());
                    kickStarter.setLocation(model.getLocation());
                    kickStarter.setPercentage(model.getPercentageFunded()+"");
                    kickStarter.setNum_backers(model.getNumBackers());
                    kickStarter.setState(model.getState());
                    kickStarter.setTitle(model.getTitle());
                    kickStarter.setType(model.getType());
                    kickStarter.setUrl(model.getUrl());
                    mKickStarterLocalDataSource.saveKickStarter(kickStarter);
                }
                loadFromDb();

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
                Preconditions.checkNotNull(throwable);
                mKickStartView.showLoadErrorMessage(throwable.getMessage());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                // mKickStartView.onLoadFinish();
            }
        });

    }

    @Override
    public void loadKickStarterDb() {
        loadFromDb();
    }

    private void loadFromDb(){
        Flowable<List<KickStarter>> listFlowable = mKickStarterLocalDataSource.getKickStarters();
        listFlowable.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull Subscription subscription) throws Exception {

            }
        }).subscribe(new Consumer<List<KickStarter>>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull List<KickStarter> kickStarters) throws Exception {
                mKickStartView.onKickStartersOk(kickStarters);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
                Preconditions.checkNotNull(throwable);
                mKickStartView.showLoadErrorMessage(throwable.getMessage());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                // mKickStartView.onLoadFinish();
            }
        });
    }

    @Override
    public void loadDetailKickStarter(boolean isDetail) {

    }

    @Override
    public long getCountDb() {
        return mKickStarterLocalDataSource.getKickStartCount();
    }
}
