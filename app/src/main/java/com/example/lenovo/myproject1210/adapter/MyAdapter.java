package com.example.lenovo.myproject1210.adapter;

import android.content.Context;

import com.example.lenovo.myproject1210.Cache;
import com.example.lenovo.myproject1210.R;
import com.example.lenovo.myproject1210.SqliteUtils;
import com.example.lenovo.myproject1210.model.MyBean;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter<MyBean.DataBean>{
    private final Context context;
    private List<Cache> cacheList;
    public MyAdapter(List<Cache> cacheList, Context context) {
        super(context);
        this.cacheList=cacheList;
        this.context=context;
        notifyDataSetChanged();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.myitem;
    }

    @Override
    protected void bindData(MyViewHolder myViewHolder, List<MyBean.DataBean> list, int i) {
        try {
            MyBean.DataBean dataBean = list.get(i);
            myViewHolder.setPic(R.id.simple,dataBean.getUser().getIcon());
            myViewHolder.setText(R.id.icon_name,dataBean.getUser().getNickname());
            myViewHolder.setText(R.id.icon_time,dataBean.getCreateTime());
            myViewHolder.setPic(R.id.simple_pic,dataBean.getImgUrls()+"");
            myViewHolder.setText(R.id.content,dataBean.getContent());
            String name = cacheList.get(i).getName();
            String content = cacheList.get(i).getContent();
            String time = cacheList.get(i).getTime();
            String simple = cacheList.get(i).getSimple();
            String simple_pic = cacheList.get(i).getSimple_pic();
            Cache cache = new Cache();
            cache.setName(name);
            cache.setContent(content);
            cache.setTime(time);
            cache.setSimple(simple);
            cache.setSimple_pic(simple_pic);
            SqliteUtils.getSqliteUtils().insert(cache);
            EventBus.getDefault().post("0");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
