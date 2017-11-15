package com.degjeg.api;

import com.degjeg.bean.SongDetail;
import com.degjeg.bean.SongListItem;

import java.util.List;

/**
 * Created by Administrator on 2017-11-15.
 */

public interface MusicApi {

    /**
     * 获取歌曲列表
     *
     * @param type
     * @return
     */
    void getSongList(int type, int offset, int size, CallBack<List<SongListItem>> callBack);


    /**
     * 搜索歌曲
     *
     * @param keyword
     * @return
     */
    void searchSong(String keyword, CallBack<List<SongListItem>> callBack);

    /**
     * 获取歌曲详情，包括
     *
     * @param songId
     * @return
     */
    void getSongDetail(String songId, CallBack<SongDetail> callBack);


    interface CallBack<T> {
        void onSuccess(T t);

        void onFail(int code, String msg, Exception e);
    }
}
