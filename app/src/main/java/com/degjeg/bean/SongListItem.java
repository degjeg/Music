package com.degjeg.bean;

/**
 * Created by Administrator on 2017-11-15.
 */

public class SongListItem {
    protected String id;
    protected String songName; // 歌曲名
    protected String artistName; // 歌手名
    protected int duration; // 时长
    protected int fileSize; // 文件大小（字节）
    protected String coverUrl; // 歌曲封面
    protected String playerAvator; // 歌手图片

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getPlayerAvator() {
        return playerAvator;
    }

    public void setPlayerAvator(String playerAvator) {
        this.playerAvator = playerAvator;
    }
}
