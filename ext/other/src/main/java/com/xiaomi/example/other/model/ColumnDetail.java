package com.xiaomi.example.other.model;

/**
 * Created by Qiushi on 2017/7/12.
 *
 * 上报平台Xml配置文件的每列元素对应的数据结构成员变量名，值以及验证方法。
 */
public class ColumnDetail {
    private String columnTag;
    private int columnFormat;
    private int columnCheckMethod; //TODO
    private boolean dataMask; //TODO

    public ColumnDetail(){
    }

    public ColumnDetail(String columnTag, int columnFormat, int columnCheckMethod, boolean dataMask) {
        this.columnTag = columnTag;
        this.columnFormat = columnFormat;
        this.columnCheckMethod = columnCheckMethod;
        this.dataMask = dataMask;
    }

    public String getColumnTag() {
        return columnTag;
    }

    public void setColumnTag(String columnTag) {
        this.columnTag = columnTag;
    }

    public int getColumnFormat() {
        return columnFormat;
    }

    public void setColumnFormat(int columnFormat) {
        this.columnFormat = columnFormat;
    }

    public int getColumnCheckMethod() {
        return columnCheckMethod;
    }

    public void setColumnCheckMethod(int columnCheckMethod) {
        this.columnCheckMethod = columnCheckMethod;
    }

    public boolean isDataMask() {
        return dataMask;
    }

    public void setDataMask(boolean dataMask) {
        this.dataMask = dataMask;
    }
}
