package com.degjeg.api.baidu.bean;

/**
 * Created by Administrator on 2017-11-15.
 */

public class BaseBaiduQueryRequest {

    private String format = "json";
    private String calback = "";
    private String from = "webapp_music";
    private String method;

    public BaseBaiduQueryRequest(String method) {
        this.method = method;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCalback() {
        return calback;
    }

    public void setCalback(String calback) {
        this.calback = calback;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
