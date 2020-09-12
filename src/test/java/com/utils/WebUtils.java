package com.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * Any random class that needs to to be created to perform any action.
 * For example this class may be a used to make DB calls, or be responsible gor making we calls.
 * Properties defined in the yml file can be injected directly, example below.
 */
public class WebUtils {

    @Value("${api.url}")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
