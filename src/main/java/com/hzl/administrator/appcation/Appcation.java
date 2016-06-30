package com.hzl.administrator.appcation;

import android.app.Application;

import com.xtremeprog.xpgconnect.XPGWifiSDK;

/**
 * @author Administrator
 * @time 2016/4/19 10:40
 */
public class Appcation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        XPGWifiSDK.sharedInstance().startWithAppID(getApplicationContext(), "1251bfb16920404da6565ab2bc5787c4");
        XPGWifiSDK.sharedInstance().setLogLevel(XPGWifiSDK.XPGWifiLogLevel.XPGWifiLogLevelAll, "GoKitDemo.log", true);
    }
}
