package com.mars.start.startmap.impl;

import com.mars.core.util.ConfigUtil;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

/**
 * 加载配置文件
 */
public class StartConfig implements StartMap {

    /**
     * 加载配置文件
     * @param startParam 参数
     * @throws Exception 异常
     */
    @Override
    public void load(StartParam startParam) throws Exception {
        ConfigUtil.loadConfig(startParam.getSuffix());
    }
}
