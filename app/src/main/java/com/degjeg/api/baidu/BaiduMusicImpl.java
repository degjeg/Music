package com.degjeg.api.baidu;

import android.util.Log;

import com.degjeg.api.MusicApi;
import com.degjeg.api.baidu.bean.BaiduSongListItem;
import com.degjeg.api.baidu.bean.BaseBaiduQueryRequest;
import com.degjeg.bean.SongDetail;
import com.degjeg.bean.SongListItem;
import com.degjeg.util.fastjson.FastJsonConverterFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017-11-15.
 */

public class BaiduMusicImpl implements MusicApi {
    OkHttpClient mClient;
    Retrofit mRetrofit;
    BaiduMusicNetApi baiduMusicNetApi;

    public BaiduMusicImpl() {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        // if(BuildConfig.DEBUG){
        //     builder.addNetworkInterceptor(new AGLogInterceptor());
        // }
        mClient = builder.build();


        mRetrofit = new Retrofit.Builder()
                .baseUrl(BaiduMusicNetApi.MUSIC_BASE_URL)
                .addConverterFactory(FastJsonConverterFactory.create())
                .client(mClient)
                .build();

        baiduMusicNetApi = mRetrofit.create(BaiduMusicNetApi.class);
    }

    public HashMap<String, String> createRequestMap(String methodName, String... pars) {
        HashMap<String, String> map = new HashMap<>();
        map.put("format", "json");
        map.put("calback", "");
        map.put("from", "webapp_music");
        map.put("method", methodName);

        for (int i = 0; i < pars.length - 1; i += 2) {
            map.put(pars[i], pars[i + 1]);
        }
        return map;
    }

    @Override
    public void getSongList(int type,int offset, int size, final CallBack<List<SongListItem>> callBack) {
        baiduMusicNetApi.getSongList(
                createRequestMap("baidu.ting.billboard.billList",
                        "type", String.valueOf(type),
                        "size", String.valueOf(size),
                        "offset", String.valueOf(offset)
                ))

                .enqueue(new Callback<List<BaiduSongListItem>>() {
                    @Override
                    public void onResponse(Call<List<BaiduSongListItem>> call, Response<List<BaiduSongListItem>> response) {

                        List<SongListItem> listItems = new ArrayList<>();
                        for (int i = 0; i < response.body().size(); i++) {
                            listItems.add(new SongListItem());
                        }
                        callBack.onSuccess(listItems);
                    }

                    @Override
                    public void onFailure(Call<List<BaiduSongListItem>> call, Throwable t) {
                        Log.e("", "", t);
                    }
                });
    }

    @Override
    public void searchSong(String keyword, CallBack<List<SongListItem>> callBack) {

    }

    @Override
    public void getSongDetail(String songId, CallBack<SongDetail> callBack) {

    }
}
