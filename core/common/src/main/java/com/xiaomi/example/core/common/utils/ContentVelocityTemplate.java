package com.xiaomi.example.core.common.utils;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

import java.util.Map;

/**
 * Created by liujin on 2017/8/3.
 */
public class ContentVelocityTemplate {
    /** 注入引擎 */
    private VelocityEngine velocityEngine;
    /** 编码 */
    private String encoding;
    /** vm 模板路径 */
    private String vmLocation;

    @SuppressWarnings("rawtypes")
    public String getContent(Map prepareData) {
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, getVmLocation(),
                encoding, prepareData);
    }

    public String getContent() {
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, getVmLocation(),
                encoding, null);
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void setVmLocation(String vmLocation) {
        this.vmLocation = vmLocation;
    }

    public String getVmLocation() {
        return this.vmLocation;
    }
}
