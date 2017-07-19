package com.xiaomi.example.other.model;

import java.util.List;

/**
 * Created by Qiushi on 2017/7/12.
 *
 * 上报平台中 每个上报任务的类结构
 * 根据ruleId和orgCode决定如何配置上报文件个数和类型
 */
public class Task {
    private int ruleId;
    private int orgCode;
    private List<File> fileList;

    public Task(){
    }

    public Task(int ruleId, int orgCode, List<File> fileList) {
        this.ruleId = ruleId;
        this.orgCode = orgCode;
        this.fileList = fileList;
    }

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public int getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(int orgCode) {
        this.orgCode = orgCode;
    }

    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }
}
