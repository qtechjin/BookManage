package com.xiaomi.example.other.model;

import java.util.List;

/**
 * Created by Qiushi on 2017/7/13.
 */
public class Lines {
    private List<String> headers;
    private List<ColumnDetail> contents;

    public Lines(List<String> headers, List<ColumnDetail> contents) {
        this.headers = headers;
        this.contents = contents;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<ColumnDetail> getContents() {
        return contents;
    }

    public void setContents(List<ColumnDetail> contents) {
        this.contents = contents;
    }
}
