package com.fred.apple.application;

import android.app.Application;

/**
 * @author Fred Liu(liuxiaokun0410@gmail.com)
 * @version v1.0.0
 * @since 2015-11-21 09:40
 */
public class MyApplication extends Application {

    private static MyApplication mApplication;

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
    }

    public static MyApplication getInstance() {
        return mApplication;
    }

}
