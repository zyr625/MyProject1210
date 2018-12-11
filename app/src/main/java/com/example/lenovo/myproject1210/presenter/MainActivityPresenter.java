package com.example.lenovo.myproject1210.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.lenovo.myproject1210.MainActivity;
import com.example.lenovo.myproject1210.R;
import com.example.lenovo.myproject1210.fragment.FourFragment;
import com.example.lenovo.myproject1210.fragment.OneFragment;
import com.example.lenovo.myproject1210.fragment.ThreeFargment;
import com.example.lenovo.myproject1210.fragment.TwoFragment;
import com.example.lenovo.myproject1210.mvp.view.AppDelegate;
import com.example.lenovo.myproject1210.tabview.TabView;
import com.example.lenovo.myproject1210.tabview.TabViewChild;

import java.util.ArrayList;
import java.util.List;

public class MainActivityPresenter extends AppDelegate {
    private TabView tabView;
    private Context context;
    private List<TabViewChild> tabViewList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        TabViewChild tabViewChild1 = new TabViewChild(R.drawable.tyes, R.drawable.tno, "推荐", new OneFragment());
        TabViewChild tabViewChild2 = new TabViewChild(R.drawable.dyes, R.drawable.dno, "段子", new TwoFragment());
        TabViewChild tabViewChild3 = new TabViewChild(R.drawable.fyes, R.drawable.fno, "发现", new ThreeFargment());
        TabViewChild tabViewChild4 = new TabViewChild(R.drawable.syes, R.drawable.sno, "视频", new FourFragment());
        tabViewList.add(tabViewChild1);
        tabViewList.add(tabViewChild2);
        tabViewList.add(tabViewChild3);
        tabViewList.add(tabViewChild4);
        tabView.setTabViewChild(tabViewList, ((MainActivity) context).getSupportFragmentManager());

    }

    @Override
    public void initContext(Context context) {
        this.context = context;
    }

    public void initView( TabView tabView) {
        this.tabView = tabView;
    }
}
