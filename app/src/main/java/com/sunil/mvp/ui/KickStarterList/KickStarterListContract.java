package com.sunil.mvp.ui.KickStarterList;


import com.sunil.mvp.base.BaseContract;
import com.sunil.mvp.db.model.KickStarter;

import java.util.List;

/**
 * Created by sunil on 12-08-2017.
 */

public class KickStarterListContract {

    public interface Presenter extends BaseContract.Presenter<View> {
        void loadKickStartersAPI();
        void loadKickStarterDb();
        void loadDetailKickStarter(boolean isDetail);
        long getCountDb();

    }

    public interface View extends BaseContract.View{
        void onKickStartersOk(List<KickStarter> kickStarters);
        void showProgress(boolean show);
        void showLoadErrorMessage(String errorMsg);
        void showEmptyView(boolean isShow);

    }
}
