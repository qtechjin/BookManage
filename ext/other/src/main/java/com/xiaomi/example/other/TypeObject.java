package com.xiaomi.example.other;

import java.util.List;

/**
 * Created by liujin on 2017/7/13.
 */

public class TypeObject {
    private String Type;
    private Boolean isEncrypt;

    private List attributes;


    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Boolean getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(Boolean isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public List getAttributes() {
        return attributes;
    }

    public void setAttributes(List attributes) {
        this.attributes = attributes;
    }
}
