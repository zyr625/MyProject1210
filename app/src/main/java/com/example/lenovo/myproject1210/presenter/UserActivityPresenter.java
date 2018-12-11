package com.example.lenovo.myproject1210.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.myproject1210.R;
import com.example.lenovo.myproject1210.UserActivity;
import com.example.lenovo.myproject1210.fragment.TwoFragment;
import com.example.lenovo.myproject1210.model.UserBean;
import com.example.lenovo.myproject1210.mvp.view.AppDelegate;
import com.example.lenovo.myproject1210.net.HttpListener;
import com.example.lenovo.myproject1210.net.OkHttpUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

public class UserActivityPresenter extends AppDelegate{
    private Context context;
    private SimpleDraweeView simpleDraweeView;
    TextView user_id,user_name,user_sex,user_data;
    private String url="http://www.zhaoapi.cn/user/getUserInfo?uid=71";

    @Override
    public int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public void initData() {
        new OkHttpUtils().get(url).result(new HttpListener() {
            @Override
            public void success(String data) {
                UserBean userBean = new Gson().fromJson(data, UserBean.class);
                simpleDraweeView.setImageURI(userBean.getData().getIcon());
                user_id.setText(userBean.getData().getMobile());
                user_name.setText(userBean.getData().getNickname());
                user_sex.setText("男");
                user_data.setText("1986年06月03日");
            }

            @Override
            public void fail(String error) {

            }
        });

    }

    @Override
    public void initContext(Context context) {
        this.context=context;
    }

    public void initView(SimpleDraweeView simpleDraweeView, TextView user_id, TextView user_name, TextView user_sex, TextView user_data) {
        this.simpleDraweeView=simpleDraweeView;
        this.user_id=user_id;
        this.user_name=user_name;
        this.user_sex=user_sex;
        this.user_data=user_data;
    }
}
