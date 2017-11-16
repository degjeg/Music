package com.degjeg.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 * Created by Administrator on 2017-11-16.
 */

public class BaseCallbackImpl<T> implements MusicApi.CallBack<T> {
    MusicApi.CallBack mainThreadCallback;
    Handler handler = new Handler(Looper.getMainLooper());

    public BaseCallbackImpl(MusicApi.CallBack mainThreadCallback) {
        this.mainThreadCallback = mainThreadCallback;
    }

    @Override
    public void onSuccess(T o) {
        handler.post(() -> {
            try {
                mainThreadCallback.onSuccess(o);
            } catch (Exception e1) {
                Log.d("", "onSuccess", e1);
            }
        });
    }

    @Override
    public void onFail(int code, String msg, Throwable e) {
        handler.post(() -> {
            try {
                mainThreadCallback.onFail(code, msg, e);
            } catch (Exception e1) {
                Log.d("", code + "-onFail-" + msg, e1);
            }
        });
    }
}
