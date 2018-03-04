package com.example.administrator.myvideo.welcome;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.myvideo.R;
import com.example.administrator.myvideo.main.MainActivity;

public class WelcomeActivity extends AppCompatActivity implements WelcomeContract.view {
    private WelcomeContract.Presenter mPresenter;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mPresenter=new WelcomePresenter(this);
        laterStartMainActivity();
    }

    private void laterStartMainActivity() {
        handler.postDelayed(mPresenter.startMainActivity(), 2000);
    }

    /**
     * 跳转到主页面并关闭当前页面
     */
    @Override
    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        startMainActivity();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }


    @Override
    public void setPresenter(WelcomeContract.Presenter presenter) {
        if (presenter != null) {
            mPresenter = presenter;
        }
    }

    @Override
    public void initViews(View view) {

    }


}
