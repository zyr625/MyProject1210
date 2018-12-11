package com.example.lenovo.myproject1210.fragment;


import android.support.v7.widget.RecyclerView;

import com.example.lenovo.myproject1210.R;
import com.example.lenovo.myproject1210.mvp.presenter.BaseFragmentPresenter;
import com.example.lenovo.myproject1210.presenter.TwoFragmentPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;

public class TwoFragment extends BaseFragmentPresenter<TwoFragmentPresenter> {
    @BindView(R.id.icon)
    SimpleDraweeView mIcon;
    @BindView(R.id.edit)
    SimpleDraweeView mEdit;
    @BindView(R.id.recyler)
    RecyclerView recyclerView;
    @Override
    public Class<TwoFragmentPresenter> getClassDelegate() {
        return TwoFragmentPresenter.class;
    }

    @Override
    public void initView() {
        super.initView();
        delegate.initView(mIcon,mEdit,recyclerView);
    }
}
