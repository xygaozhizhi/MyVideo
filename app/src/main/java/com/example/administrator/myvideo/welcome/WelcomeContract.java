package com.example.administrator.myvideo.welcome;

import com.example.administrator.myvideo.BasePresenter;
import com.example.administrator.myvideo.BaseView;

/**
 * Created by Administrator on 2017/12/19.
 */

public class WelcomeContract {
    interface view extends BaseView<Presenter>{
        void startMainActivity();

    }
    interface Presenter extends BasePresenter{
        Runnable startMainActivity();
    }
}
