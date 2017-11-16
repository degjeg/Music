package com.degjeg.api.baidu.bean;

/**
 * {
 * "songinfo": {
 * "special_type": 0,
 * "pic_huge": "http://musicdata.baidu.com/data2/pic/c4334247844b6635b83c4de6f5993dbf/564124806/564124806.JPG",
 * "ting_uid": "2517",
 * "pic_premium": "http://musicdata.baidu.com/data2/pic/c4334247844b6635b83c4de6f5993dbf/564124806/564124806.JPG@s_1,w_500,h_500",
 * "havehigh": 2,
 * "si_proxycompany": "TAIHE MUSIC GROUP",
 * "author": "薛之谦",
 * "toneid": "0",
 * "has_mv": 0,
 * "song_id": "564102115",
 * "title": "别",
 * "artist_id": "88",
 * "lrclink": "http://musicdata.baidu.com/data2/lrc/4ca11ed349ed0c1e6488ad1bd664812b/565001257/565001257.lrc",
 * "relate_status": "0",
 * "learn": 0,
 * "pic_big": "http://musicdata.baidu.com/data2/pic/c4334247844b6635b83c4de6f5993dbf/564124806/564124806.JPG@s_1,w_150,h_150",
 * "play_type": 0,
 * "album_id": "564102092",
 * "pic_radio": "http://musicdata.baidu.com/data2/pic/c4334247844b6635b83c4de6f5993dbf/564124806/564124806.JPG@s_1,w_300,h_300",
 * "bitrate_fee": "{\"0\":\"0|0\",\"1\":\"0|0\"}",
 * "song_source": "web",
 * "all_artist_id": "88",
 * "all_artist_ting_uid": "2517",
 * "piao_id": "0",
 * "charge": 0,
 * "copy_type": "0",
 * "all_rate": "64,128,256,320,flac",
 * "korean_bb_song": "0",
 * "is_first_publish": 0,
 * "has_mv_mobile": 0,
 * "album_title": "别",
 * "pic_small": "http://musicdata.baidu.com/data2/pic/c4334247844b6635b83c4de6f5993dbf/564124806/564124806.JPG@s_1,w_90,h_90",
 * "album_no": "0",
 * "resource_type_ext": "0",
 * "resource_type": "0"
 * },
 * "error_code": 22000,
 * "bitrate": {
 * "show_link": "http://zhangmenshiting.baidu.com/data2/music/39f54b18e03047961ef4ef7104996689/564102560/564102560.mp3?xcode=4281fda9a46b0c9c96a2d3f13bf86a03",
 * "free": 1,
 * "song_file_id": 564102560,
 * "file_size": 1726825,
 * "file_extension": "mp3",
 * "file_duration": 216,
 * "file_bitrate": 64,
 * "file_link": "http://yinyueshiting.baidu.com/data2/music/39f54b18e03047961ef4ef7104996689/564102560/564102560.mp3?xcode=4281fda9a46b0c9c96a2d3f13bf86a03",
 * "hash": "663b51b5efac84c7fda7c20205b928e39f6c4e89"
 * }
 * }
 */

public class BaiduSongDetailResponse {
    private Songinfo songinfo;
    private BitRate bitrate;

    public Songinfo getSonginfo() {
        return songinfo;
    }

    public void setSonginfo(Songinfo songinfo) {
        this.songinfo = songinfo;
    }

    public BitRate getBitrate() {
        return bitrate;
    }

    public void setBitrate(BitRate bitrate) {
        this.bitrate = bitrate;
    }

    public static class Songinfo {
        // "special_type": 0,
        // "pic_huge": "http://musicdata.baidu.com/data2/pic/c4334247844b6635b83c4de6f5993dbf/564124806/564124806.JPG",
        // "ting_uid": "2517",
        // "pic_premium": "http://musicdata.baidu.com/data2/pic/c4334247844b6635b83c4de6f5993dbf/564124806/564124806.JPG@s_1,w_500,h_500",
        // "havehigh": 2,
        // "si_proxycompany": "TAIHE MUSIC GROUP",
        // "author": "薛之谦",
        // "toneid": "0",
        // "has_mv": 0,
        public String song_id; // ": "564102115",
        // "title": "别",
        // "artist_id": "88",
        public String lrclink; // ": "http://musicdata.baidu.com/data2/lrc/4ca11ed349ed0c1e6488ad1bd664812b/565001257/565001257.lrc",
        // "relate_status": "0",
        // "learn": 0,
        // "pic_big": "http://musicdata.baidu.com/data2/pic/c4334247844b6635b83c4de6f5993dbf/564124806/564124806.JPG@s_1,w_150,h_150",
        // "play_type": 0,
        // "album_id": "564102092",
        // "pic_radio": "http://musicdata.baidu.com/data2/pic/c4334247844b6635b83c4de6f5993dbf/564124806/564124806.JPG@s_1,w_300,h_300",
        // "bitrate_fee": "{\"0\":\"0|0\",\"1\":\"0|0\"}",
        // "song_source": "web",
        // "all_artist_id": "88",
        // "all_artist_ting_uid": "2517",
        // "piao_id": "0",
        // "charge": 0,
        // "copy_type": "0",
        // "all_rate": "64,128,256,320,flac",
        // "korean_bb_song": "0",
        // "is_first_publish": 0,
        // "has_mv_mobile": 0,
        // "album_title": "别",
        // "pic_small": "http://musicdata.baidu.com/data2/pic/c4334247844b6635b83c4de6f5993dbf/564124806/564124806.JPG@s_1,w_90,h_90",
        // "album_no": "0",
        // "resource_type_ext": "0",
        // "resource_type": "0"


    }

    public static class BitRate {
        // "bitrate": {
        // "show_link": "http://zhangmenshiting.baidu.com/data2/music/39f54b18e03047961ef4ef7104996689/564102560/564102560.mp3?xcode=4281fda9a46b0c9c96a2d3f13bf86a03",
        // "free": 1,
        // "song_file_id": 564102560,
        public int file_size; // ": 1726825,
        // "file_extension": "mp3",
        public int file_duration; // ": 216,
        //   "file_bitrate": 64,
        public String file_link; // ": "http://yinyueshiting.baidu.com/data2/music/39f54b18e03047961ef4ef7104996689/564102560/564102560.mp3?xcode=4281fda9a46b0c9c96a2d3f13bf86a03",
        // "hash": "663b51b5efac84c7fda7c20205b928e39f6c4e89"
    }
}

