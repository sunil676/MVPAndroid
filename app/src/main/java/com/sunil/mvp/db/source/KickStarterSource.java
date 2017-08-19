package com.sunil.mvp.db.source;

import android.support.annotation.NonNull;

import com.sunil.mvp.db.model.KickStarter;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

/**
 * Created by sunil on 12-08-2017.
 */

public interface KickStarterSource {

    Flowable<List<KickStarter>> getKickStarters();

    Observable<KickStarter> getKickStarterById(long rowId);

    void saveKickStarter(@NonNull KickStarter kickStarter);

    void deleteKickStarter(@NonNull String id);

    long getKickStartCount();

}
