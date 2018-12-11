package com.example.lenovo.myproject1210.fragment;


import com.example.lenovo.myproject1210.mvp.presenter.BaseFragmentPresenter;
import com.example.lenovo.myproject1210.presenter.ThreeFragmentPresenter;

public class ThreeFargment extends BaseFragmentPresenter<ThreeFragmentPresenter> {
    @Override
    public Class<ThreeFragmentPresenter> getClassDelegate() {
        return ThreeFragmentPresenter.class;
    }
}
