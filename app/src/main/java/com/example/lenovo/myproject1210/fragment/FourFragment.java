package com.example.lenovo.myproject1210.fragment;


import com.example.lenovo.myproject1210.mvp.presenter.BaseFragmentPresenter;
import com.example.lenovo.myproject1210.presenter.FourFragmentPresenter;

public class FourFragment extends BaseFragmentPresenter<FourFragmentPresenter> {
    @Override
    public Class<FourFragmentPresenter> getClassDelegate() {
        return FourFragmentPresenter.class;
    }
}
