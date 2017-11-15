package com.degjeg.api.baidu.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.degjeg.bean.SongListItem;

/**
 * Created by Administrator on 2017-11-15.
 */

public class BaiduSongListItem extends SongListItem {
    @JSONField(name = "song_id")
    protected String id;

    @JSONField(name = "title")
    protected String songName; // 歌曲名

    @JSONField(name = "artist_name")
    protected String artistName; // 歌手名

    @JSONField(name = "file_duration")
    protected int duration; // 时长

    protected int fileSize; // 文件大小（字节）

    @JSONField(name = "album_500_500")
    protected String coverUrl; // 歌曲封面

    @JSONField(name = "pic_big")
    protected String playerAvator; // 歌手图片

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getSongName() {
        return songName;
    }

    @Override
    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Override
    public String getArtistName() {
        return artistName;
    }

    @Override
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int getFileSize() {
        return fileSize;
    }

    @Override
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String getCoverUrl() {
        return coverUrl;
    }

    @Override
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    @Override
    public String getPlayerAvator() {
        return playerAvator;
    }

    @Override
    public void setPlayerAvator(String playerAvator) {
        this.playerAvator = playerAvator;
    }
}
