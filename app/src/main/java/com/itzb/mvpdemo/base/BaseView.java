package com.itzb.mvpdemo.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * View层基类
 */
public abstract class BaseView<P extends BasePresenter, CONTRACT> extends AppCompatActivity {
    protected P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        p = getPresenter();

        p.bindView(this);
    }

    //P层做什么需求
    public abstract CONTRACT getContract();

    //从子类中获取具体的契约
    public abstract P getPresenter();


    //如果Presenter层出现异常，需要告知View层
    public void error(Exception e) {
    }

    @Override
    protected void onDestroy() {
        p.unbindView();
        super.onDestroy();
    }
}
