package com.example.lenovo.myproject1210;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.myproject1210.mvp.presenter.BaseActivityPresenter;
import com.example.lenovo.myproject1210.presenter.UserActivityPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;

public class UserActivity extends BaseActivityPresenter<UserActivityPresenter> {

    @BindView(R.id.simpleView)
    SimpleDraweeView simpleDraweeView;
    @BindView(R.id.user_id)
    TextView user_id;
    @BindView(R.id.user_name)
    TextView user_name;
    @BindView(R.id.user_sex)
    TextView user_sex;
    @BindView(R.id.user_data)
    TextView user_data;
    @Override
    public Class<UserActivityPresenter> getClassDelegate() {
        return UserActivityPresenter.class;
    }

    @Override
    public void initView() {
        super.initView();
        delegate.initView(simpleDraweeView,user_id,user_name,user_sex,user_data);
    }
}
