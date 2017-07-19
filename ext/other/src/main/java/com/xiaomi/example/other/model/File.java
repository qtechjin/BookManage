package com.xiaomi.example.other.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qiushi on 2017/7/12.
 *
 * 上报平台每个上报文件的类结构
 */
public class File {
    private int type;
        private List<String> tradeCodes;
    private List<String> orgCodes;
    private boolean encrypt;
    private String fileName;
    private int ruleId;
    private char splitChar;
    private int source;
    private Lines lines;

    public File(int type, List<String> tradeCodes, List<String> orgCodes, boolean encrypt, String fileName, int ruleId, char splitChar, int source, Lines lines) {
        this.type = type;
        this.tradeCodes = tradeCodes;
        this.orgCodes = orgCodes;
        this.encrypt = encrypt;
        this.fileName = fileName;
        this.ruleId = ruleId;
        this.splitChar = splitChar;
        this.source = source;
        this.lines = lines;
    }

    public File() {
        this.lines = new Lines(new ArrayList<String>(), new ArrayList<ColumnDetail>());
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getTradeCodes() {
        return tradeCodes;
    }

    public void setTradeCodes(List<String> tradeCodes) {
        this.tradeCodes = tradeCodes;
    }

    public List<String> getOrgCodes() {
        return orgCodes;
    }

    public void setOrgCodes(List<String> orgCodes) {
        this.orgCodes = orgCodes;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public char getSplitChar() {
        return splitChar;
    }

    public void setSplitChar(char splitChar) {
        this.splitChar = splitChar;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public Lines getLines() {
        return lines;
    }
}
