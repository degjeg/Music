package com.degjeg.api.baidu;

import com.degjeg.api.baidu.bean.BaiduSongListItem;
import com.degjeg.api.baidu.bean.BaseBaiduQueryRequest;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;


/**
 * Created by Administrator on 2017-11-15.
 */

public interface BaiduMusicNetApi {
    String MUSIC_BASE_URL = "http://tingapi.ting.baidu.com/";

    @GET("v1/restserver/ting")
    Call<List<BaiduSongListItem>> getSongList(@QueryMap HashMap<String, String> pars);


}
