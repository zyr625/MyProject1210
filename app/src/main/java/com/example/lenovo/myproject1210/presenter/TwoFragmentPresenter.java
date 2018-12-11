package com.example.lenovo.myproject1210.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lenovo.myproject1210.Cache;
import com.example.lenovo.myproject1210.R;
import com.example.lenovo.myproject1210.SqliteUtils;
import com.example.lenovo.myproject1210.UserActivity;
import com.example.lenovo.myproject1210.adapter.MyAdapter;
import com.example.lenovo.myproject1210.model.MyBean;
import com.example.lenovo.myproject1210.mvp.view.AppDelegate;
import com.example.lenovo.myproject1210.net.HttpListener;
import com.example.lenovo.myproject1210.net.OkHttpUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class TwoFragmentPresenter extends AppDelegate {
    private SimpleDraweeView mIcon, mEdit;
    private RecyclerView recyclerView;
    private Context context;
    private MyAdapter myAdapter;
    private String url = "http://www.zhaoapi.cn/quarter/getJokes?source=android&appVersion=1&page=1";

    @Override
    public int getLayoutId() {
        return R.layout.two;
    }

    @Override
    public void initData() {
        mIcon.setImageResource(R.drawable.user_icon);
        mEdit.setImageResource(R.drawable.edit_icon);
        mIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, UserActivity.class));
            }
        });
        EventBus.getDefault().register(this);
        List<Cache> cacheList = SqliteUtils.getSqliteUtils().queryAll();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        myAdapter = new MyAdapter(cacheList, context);
        recyclerView.setAdapter(myAdapter);
        doHttp();
    }

    private void doHttp() {
        new OkHttpUtils().get(url).result(new HttpListener() {
            @Override
            public void success(String data) {
                MyBean myBean = new Gson().fromJson(data, MyBean.class);
                myAdapter.setList(myBean.getData());
            }

            @Override
            public void fail(String error) {

            }
        });
    }

    @Override
    public void initContext(Context context) {
        this.context = context;
    }


    @Override
    public void onDestory() {
        super.onDestory();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String msg) {
        List<Cache> list = SqliteUtils.getSqliteUtils().queryAll();
        myAdapter.notifyDataSetChanged();
    }

    public void initView(SimpleDraweeView mIcon, SimpleDraweeView mEdit, RecyclerView recyclerView) {
        this.mIcon = mIcon;
        this.mEdit = mEdit;
        this.recyclerView = recyclerView;
    }

}
