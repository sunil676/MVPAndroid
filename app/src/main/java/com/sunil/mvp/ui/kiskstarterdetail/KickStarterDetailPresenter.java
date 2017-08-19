package com.sunil.mvp.ui.kiskstarterdetail;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.sunil.mvp.db.model.KickStarter;
import com.sunil.mvp.db.source.KickStarterLocalSource;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;


/**
 * Created by sunil on 19-08-2017.
 */

public class KickStarterDetailPresenter implements KickStarterDetailContract.Presenter{

    @NonNull
    private KickStarterDetailContract.View mKickStartView;
    private Context context;
    private CompositeDisposable mCompositeDisposable;
    private  KickStarterLocalSource kickStarterLocalSource;


    public KickStarterDetailPresenter(){
        kickStarterLocalSource = new KickStarterLocalSource();
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
    public void attachView(KickStarterDetailContract.View view) {
        mKickStartView = view;
    }

    @Override
    public void loadDetailKickStarter(int s_n0) {

        Log.v("", "S_SN: "+s_n0);
        Observable<KickStarter> kickStarterObservable = kickStarterLocalSource.getKickStarterById(s_n0);
        kickStarterObservable.doOnDispose(new Action() {
            @Override
            public void run() throws Exception {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
            }
        }).subscribe(new Consumer<KickStarter>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull KickStarter kickStarter) throws Exception {
                mKickStartView.onKickStartersOk(kickStarter);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(@io.reactivex.annotations.NonNull Throwable throwable) throws Exception {
                mKickStartView.showLoadErrorMessage(throwable.getMessage());
            }
        }, new Action() {
            @Override
            public void run() throws Exception {
                mKickStartView.showLoadErrorMessage("Error");
            }
        });

    }
}
