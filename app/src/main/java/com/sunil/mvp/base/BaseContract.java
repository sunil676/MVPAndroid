package com.sunil.mvp.base;

/**
 * Created by sunil on 19-08-2017.
 */

public class BaseContract {

    public interface Presenter<T>{
        void subscribe();
        void unSubscribe();
        void attachView(T view);
    }

    public interface View {

    }
}
