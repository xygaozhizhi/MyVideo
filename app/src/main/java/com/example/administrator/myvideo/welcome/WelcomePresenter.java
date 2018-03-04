package com.example.administrator.myvideo.welcome;

import android.os.Handler;

/**
 * Created by Administrator on 2017/12/19.
 */

public class WelcomePresenter implements WelcomeContract.Presenter{
    private WelcomeContract.view mView;

    public WelcomePresenter(WelcomeContract.view mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public Runnable startMainActivity() {
        return new Runnable() {
            @Override
            public void run() {
                mView.startMainActivity();
            }
        };
    }
}
