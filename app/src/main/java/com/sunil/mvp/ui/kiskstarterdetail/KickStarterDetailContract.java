package com.sunil.mvp.ui.kiskstarterdetail;

import com.sunil.mvp.base.BaseContract;
import com.sunil.mvp.db.model.KickStarter;

import java.util.List;

/**
 * Created by sunil on 19-08-2017.
 */

public class KickStarterDetailContract {

    public interface Presenter extends BaseContract.Presenter<KickStarterDetailContract.View> {
        void loadDetailKickStarter(int s_no);
    }

    public interface View extends BaseContract.View{
        void onKickStartersOk(KickStarter kickStarter);
        void showLoadErrorMessage(String errorMsg);
        void showEmptyView(boolean isShow);

    }
}
