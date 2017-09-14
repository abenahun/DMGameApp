package com.stx.xhb.dmgameapp.base;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.stx.xhb.dmgameapp.R;
import com.umeng.analytics.MobclickAgent;

/**
 * Author：xiaohaibin
 * Time：2017/9/13
 * Emil：xhb_199409@163.com
 * Github：https://github.com/xiaohaibin/
 * Describe：基类AppCompatActivity
 */

public abstract class BaseAppActitity extends AppCompatActivity {

    protected void initToolBar(Toolbar toolbar,String title){
            if (toolbar!=null){
                setSupportActionBar(toolbar);
                ActionBar actionBar = getSupportActionBar();
                if (actionBar!=null) {
                    actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorBackground)));
                    //设置显示返回上一级的图标
                    actionBar.setDisplayHomeAsUpEnabled(true);
                    //设置标题
                    actionBar.setTitle(title);
                    actionBar.setDisplayShowCustomEnabled(true);
                    //设置标题栏字体颜色
                    toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                    toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));
                }
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
            }
    }

    protected void setSatusBar(){
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary));
    }


    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPause(this);
    }
}
