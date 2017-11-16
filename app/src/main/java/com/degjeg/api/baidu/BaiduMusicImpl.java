package com.degjeg.api.baidu;

import android.util.Log;

import com.degjeg.api.BaseCallbackImpl;
import com.degjeg.api.MusicApi;
import com.degjeg.api.baidu.bean.BaiduSongDetailResponse;
import com.degjeg.api.baidu.bean.BaiduSongListItem;
import com.degjeg.api.baidu.bean.BaiduSongListResponse;
import com.degjeg.bean.SongCategory;
import com.degjeg.bean.SongDetail;
import com.degjeg.bean.SongListItem;
import com.degjeg.util.retrofit.HttpLoggingInterceptor;
import com.degjeg.util.retrofit.fastjson.FastJsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017-11-15.
 */

public class BaiduMusicImpl implements MusicApi {
    public static final String TAG = "BaiduMusicImpl";
    public static final String[] HEADERS = {"User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0"};

    OkHttpClient mClient;
    Retrofit mRetrofit;
    BaiduMusicNetApi baiduMusicNetApi;

    public BaiduMusicImpl() {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e(TAG, message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);


        builder.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36")
                        .build();
                return chain.proceed(request);
            }
        });
        builder.addInterceptor(loggingInterceptor);
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

    /**
     * 1-新歌榜,2-热歌榜,11-摇滚榜,12-爵士,16-流行,21-欧美金曲榜,22-经典老歌榜,23-情歌对唱榜,24-影视金曲榜,25-网络歌曲榜
     *
     * @param callBack
     */
    @Override
    public void getSongCategories(CallBack<List<SongCategory>> callBack) {
        List<SongCategory> categories = new ArrayList<>();

        categories.add(new SongCategory("1", "新歌榜"));
        categories.add(new SongCategory("2", "热歌榜"));
        categories.add(new SongCategory("11", "摇歌榜"));
        categories.add(new SongCategory("12", "爵士"));
        categories.add(new SongCategory("16", "流行"));
        categories.add(new SongCategory("21", "欧美金曲榜"));
        categories.add(new SongCategory("22", "经典老歌榜"));
        categories.add(new SongCategory("23", "情歌对唱"));
        categories.add(new SongCategory("24", "影视金曲榜"));
        categories.add(new SongCategory("25", "网络歌曲榜"));
        callBack.onSuccess(categories);
    }

    @Override
    public void getSongList(String type, int offset, int size, final CallBack<List<SongListItem>> callBack) {

        baiduMusicNetApi.getSongList(
                createRequestMap("baidu.ting.billboard.billList",
                        "type", String.valueOf(type),
                        "size", String.valueOf(size),
                        "offset", String.valueOf(offset)
                ))

                .enqueue(new Callback<BaiduSongListResponse>() {
                    @Override
                    public void onResponse(Call<BaiduSongListResponse> call, Response<BaiduSongListResponse> response) {
                        List<SongListItem> listItems = new ArrayList<>();
                        if (response.body() != null && response.body().getSong_list() != null) {
                            for (int i = 0; i < response.body().getSong_list().size(); i++) {
                                BaiduSongListItem item = response.body().getSong_list().get(i);
                                listItems.add(new SongListItem(
                                        item.getId(),
                                        item.getSongName(),
                                        item.getArtistName(),
                                        item.getDuration(),
                                        item.getFileSize(),
                                        item.getCoverUrl(),
                                        item.getPlayerAvator()
                                ));
                            }
                        }

                        new BaseCallbackImpl<List<SongListItem>>(callBack).onSuccess(listItems);
                    }

                    @Override
                    public void onFailure(Call<BaiduSongListResponse> call, Throwable t) {
                        new BaseCallbackImpl<List<SongListItem>>(callBack).onFail(-1, "", t);
                    }
                });
    }

    @Override
    public void searchSong(String keyword, CallBack<List<SongListItem>> callBack) {

    }

    @Override
    public void getSongDetail(String songId, CallBack<SongDetail> callBack) {
        baiduMusicNetApi.getSongDetail(createRequestMap("baidu.ting.song.play",
                "songid", songId
        )).enqueue(new Callback<BaiduSongDetailResponse>() {
            @Override
            public void onResponse(Call<BaiduSongDetailResponse> call, Response<BaiduSongDetailResponse> response) {
                BaiduSongDetailResponse body = response.body();

                SongDetail detail = new SongDetail();
                detail.setFileUrl(body.getBitrate().file_link);
                detail.setLrcUrl(body.getSonginfo().lrclink);
                detail.setDuration(body.getBitrate().file_duration);
                detail.setId(body.getSonginfo().song_id);

                new BaseCallbackImpl<SongDetail>(callBack).onSuccess(detail);
            }

            @Override
            public void onFailure(Call<BaiduSongDetailResponse> call, Throwable t) {
                new BaseCallbackImpl<SongDetail>(callBack).onFail(-1, "", t);
            }
        });
    }
}
