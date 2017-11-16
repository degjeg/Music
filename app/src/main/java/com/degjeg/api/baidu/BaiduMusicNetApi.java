package com.degjeg.api.baidu;

import com.degjeg.api.baidu.bean.BaiduSongDetailResponse;
import com.degjeg.api.baidu.bean.BaiduSongListResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


/**
 * Created by Administrator on 2017-11-15.
 */

public interface BaiduMusicNetApi {
    String MUSIC_BASE_URL = "http://tingapi.ting.baidu.com/";

    @GET("v1/restserver/ting")
    // @Headers({MUSIC_BASE_URL})
    Call<BaiduSongListResponse> getSongList(@QueryMap HashMap<String, String> pars);

    @GET("v1/restserver/ting")
        // @Headers({MUSIC_BASE_URL})
    Call<BaiduSongDetailResponse> getSongDetail(@QueryMap HashMap<String, String> pars);


}
