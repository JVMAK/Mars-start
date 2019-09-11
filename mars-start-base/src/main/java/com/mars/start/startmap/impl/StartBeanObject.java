package com.mars.start.startmap.impl;

import com.mars.ioc.load.LoadEasyBean;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

public class StartBeanObject implements StartMap {

    /**
     * 创建bean对象
     * @param startParam
     * @throws Exception
     */
    @Override
    public void load(StartParam startParam) throws Exception {
        LoadEasyBean.loadBean();
    }

}