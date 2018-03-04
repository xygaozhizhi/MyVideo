package com.example.administrator.myvideo.main;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.myvideo.R;
import com.example.administrator.myvideo.fragment.AudioFragment;
import com.example.administrator.myvideo.fragment.NetAudioFragment;
import com.example.administrator.myvideo.fragment.NetVideoFragment;
import com.example.administrator.myvideo.fragment.VideoFragment;
import com.example.administrator.myvideo.videoAdapter.VideoFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager vp_main_content;
    RadioGroup rg_button_tag;
    RadioButton rb_video;
    RadioButton rb_audio;
    RadioButton rb_net_video;
    RadioButton rb_net_audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp_main_content = (ViewPager) findViewById(R.id.vp_main_content);
        rg_button_tag = (RadioGroup) findViewById(R.id.rg_button_tag);
        rb_video = (RadioButton) findViewById(R.id.rb_video);
        rb_audio = (RadioButton) findViewById(R.id.rb_audio);
        rb_net_video = (RadioButton) findViewById(R.id.rb_net_video);
        rb_net_audio = (RadioButton) findViewById(R.id.rb_net_audio);
        rb_video.setChecked(true);
        rg_button_tag.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_video:
                        vp_main_content.setCurrentItem(0, false);
                        break;
                    case R.id.rb_audio:
                        vp_main_content.setCurrentItem(1, false);
                        break;
                    case R.id.rb_net_video:
                        vp_main_content.setCurrentItem(2, false);
                        break;
                    case R.id.rb_net_audio:
                        vp_main_content.setCurrentItem(3, false);
                        break;
                }
            }
        });
        VideoFragment videoFragment=new VideoFragment();
        AudioFragment audioFragment=new AudioFragment();
        NetVideoFragment netVideoFragment=new NetVideoFragment();
        NetAudioFragment netAudioFragment=new NetAudioFragment();
        List<Fragment> allList=new ArrayList<Fragment>();
        allList.add(videoFragment);
        allList.add(audioFragment);
        allList.add(netVideoFragment);
        allList.add(netAudioFragment);
        vp_main_content.setAdapter(new VideoFragmentAdapter(getSupportFragmentManager(),allList));
        vp_main_content.setCurrentItem(0);
        vp_main_content.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rg_button_tag.check(R.id.rb_video);
                        break;
                    case 1:
                        rg_button_tag.check(R.id.rb_audio);
                        break;
                    case 2:
                        rg_button_tag.check(R.id.rb_net_video);
                        break;
                    case 3:
                        rg_button_tag.check(R.id.rb_net_audio);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
