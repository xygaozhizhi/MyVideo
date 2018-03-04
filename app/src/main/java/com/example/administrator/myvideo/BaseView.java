package com.example.administrator.myvideo;

import android.view.View;

/**
 * Created by Administrator on 2017/12/19.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
    void initViews(View view);
}
