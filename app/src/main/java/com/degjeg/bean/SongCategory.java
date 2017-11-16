package com.degjeg.bean;

/**
 * Created by Administrator on 2017-11-16.
 */

public class SongCategory {
    private String id;
    private String name;

    public SongCategory() {
    }

    public SongCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
