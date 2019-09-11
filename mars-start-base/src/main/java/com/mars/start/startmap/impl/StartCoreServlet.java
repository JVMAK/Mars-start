package com.mars.start.startmap.impl;

import com.mars.core.constant.MarsSpace;
import com.mars.mvc.servlet.MarsCoreServlet;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

/**
 * 配置核心servlet
 */
public class StartCoreServlet implements StartMap {

    /**
     * 获取全局存储空间
     */
    private MarsSpace constants = MarsSpace.getEasySpace();

    /**
     * 配置核心servlet
     * @param startParam 参数
     * @throws Exception 异常
     */
    @Override
    public void load(StartParam startParam) throws Exception {
        constants.setAttr("core", MarsCoreServlet.class.getName());
    }
}
