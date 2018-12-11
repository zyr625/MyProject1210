package com.example.lenovo.myproject1210;

import android.support.v4.view.ViewPager;

import com.example.lenovo.myproject1210.mvp.presenter.BaseActivityPresenter;
import com.example.lenovo.myproject1210.presenter.MainActivityPresenter;
import com.example.lenovo.myproject1210.tabview.TabView;

import butterknife.BindView;

public class MainActivity extends BaseActivityPresenter<MainActivityPresenter> {

    @BindView(R.id.tabview)
    TabView tabView;

    @Override
    public Class<MainActivityPresenter> getClassDelegate() {
        return MainActivityPresenter.class;
    }

    @Override
    public void initView() {
        super.initView();
        delegate.initView(tabView);
    }
}
