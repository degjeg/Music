package com.degjeg.bean;

/**
 * Created by Administrator on 2017-11-15.
 */

public class SongDetail {
    private String id;
    private String fileUrl; // 歌曲内容
    private String lrcUrl; // 歌词url
    private long duration; // 时长
    private String coverUrl; // 歌曲封面
    private String playerAvator; // 歌手图片

    public SongDetail() {
    }

    public SongDetail(String id, String fileUrl, String lrcUrl, long duration, String coverUrl, String playerAvator) {
        this.id = id;
        this.fileUrl = fileUrl;
        this.lrcUrl = lrcUrl;
        this.duration = duration;
        this.coverUrl = coverUrl;
        this.playerAvator = playerAvator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getLrcUrl() {
        return lrcUrl;
    }

    public void setLrcUrl(String lrcUrl) {
        this.lrcUrl = lrcUrl;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
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
