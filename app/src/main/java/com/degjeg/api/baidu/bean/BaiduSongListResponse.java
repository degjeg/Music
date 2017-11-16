package com.degjeg.api.baidu.bean;

import java.util.List;

/**
 * Created by Administrator on 2017-11-15.
 */

public class BaiduSongListResponse {

    private List<BaiduSongListItem> song_list;

    public List<BaiduSongListItem> getSong_list() {
        return song_list;
    }

    public void setSong_list(List<BaiduSongListItem> song_list) {
        this.song_list = song_list;
    }
}
