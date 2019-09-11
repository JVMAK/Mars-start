package com.mars.start.startmap.impl;

import com.mars.core.constant.MarsSpace;
import com.mars.mvc.servlet.MarsCoreServlet;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

public class StartCoreServlet implements StartMap {

    /**
     * 获取全局存储空间
     */
    private MarsSpace constants = MarsSpace.getEasySpace();

    /**
     * 配置核心servlet
     * @param startParam
     * @throws Exception
     */
    @Override
    public void load(StartParam startParam) throws Exception {
        constants.setAttr("core", MarsCoreServlet.class.getName());
    }
}
