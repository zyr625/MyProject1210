package com.example.lenovo.myproject1210.fragment;


import com.example.lenovo.myproject1210.mvp.presenter.BaseFragmentPresenter;
import com.example.lenovo.myproject1210.presenter.OneFragmentPresenter;

public class OneFragment extends BaseFragmentPresenter<OneFragmentPresenter> {
    @Override
    public Class<OneFragmentPresenter> getClassDelegate() {
        return OneFragmentPresenter.class;
    }
}
