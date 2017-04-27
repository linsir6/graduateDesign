package com.lin_sir.beautycar.app;

import android.app.Application;
import android.content.Context;


/**
 * Created by linSir on 17/2/27.全局的context,构造一些。 this
 */
public class BaseApplication extends Application{
    private static BaseApplication mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
    }

    public static BaseApplication get() {
        return mApp;
    }

    public Context getAppContext() {
        return getApplicationContext();
    }
}
