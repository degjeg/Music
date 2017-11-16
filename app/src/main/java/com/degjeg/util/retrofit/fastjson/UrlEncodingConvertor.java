package com.degjeg.util.retrofit.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import retrofit2.Converter;

/**
 * Created by Administrator on 2017-11-15.
 */

public class UrlEncodingConvertor implements Converter<Object, String> {
    @Override
    public String convert(Object value) throws IOException {
        String jsonString = JSON.toJSONString(value);
        JSONObject jsonObject = JSON.parseObject(jsonString);

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            builder.append(entry.getKey())
                    .append("=")
                    .append(URLEncoder.encode(entry.getValue().toString(), "utf-8"))
                    .append("&");
        }
        if (builder.length() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }
}
