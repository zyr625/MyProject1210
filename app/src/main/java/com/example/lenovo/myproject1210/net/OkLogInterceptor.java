package com.example.lenovo.myproject1210.net;

import android.util.Log;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

//日志拦截器
public class OkLogInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        String method = request.method();
        HttpUrl url = request.url();
        Log.i("本次请求", "ulr：" + url.toString() + "  method:" + method);

        Headers headers = request.headers();
        Set<String> names = headers.names();
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            String value = headers.get(next);
            Log.d(next  ,":"+value);
        }
        return chain.proceed(request);
    }
}

