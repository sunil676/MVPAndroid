package com.sunil.mvp.db.source;

import android.support.annotation.NonNull;

import com.sunil.mvp.db.GreenDaoDatabase;
import com.sunil.mvp.db.model.KickStarter;
import com.sunil.mvp.db.model.KickStarterDao;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import timber.log.Timber;

/**
 * Created by sunil on 12-08-2017.
 */

public class KickStarterLocalSource implements KickStarterSource{

    private final  static String TAG = KickStarterLocalSource.class.getSimpleName();

    private KickStarterDao getKickStarterDao() {
        Timber.d(TAG, "getArticleDao()", Thread.currentThread().getName(), Thread.currentThread().getId());
        return GreenDaoDatabase.getInstance().getDaoSession().getKickStarterDao();
    }
    @Override
    public Flowable<List<KickStarter>> getKickStarters() {
        return Flowable.fromCallable(new Callable<List<KickStarter>>() {
            @Override
            public List<KickStarter> call() throws Exception {
                Timber.d(TAG, "getKickStarters()", Thread.currentThread().getName(), Thread.currentThread().getId());
                List<KickStarter> list = getKickStarterDao().loadAll();
                Timber.d("getKickStarters: " + list.size());
                return list;
            }
        });
    }

    @Override
    public Observable<KickStarter> getKickStarterById(final long rowId) {
        return Observable.fromCallable(new Callable<KickStarter>() {
            @Override
            public KickStarter call() throws Exception {
                Timber.d(TAG, "getKickStarterById()", Thread.currentThread().getName(), Thread.currentThread().getId());
                KickStarter kickStarter = getKickStarterDao().load(rowId);
                return kickStarter;
            }

        });
    }

    @Override
    public void saveKickStarter(@NonNull KickStarter kickStarter) {
        Timber.d(TAG, "saveKickStarter()", Thread.currentThread().getName(), Thread.currentThread().getId());
        getKickStarterDao().insertOrReplace(kickStarter);

    }

    @Override
    public void deleteKickStarter(@NonNull String id) {
        Timber.d(TAG, "deleteKickStarter()", Thread.currentThread().getName(), Thread.currentThread().getId());
        getKickStarterDao().deleteByKey(Long.valueOf(id));
    }

    @Override
    public long getKickStartCount() {
        return getKickStarterDao().count();
    }
}
