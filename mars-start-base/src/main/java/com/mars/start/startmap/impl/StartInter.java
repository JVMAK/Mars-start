package com.mars.start.startmap.impl;

import com.mars.mvc.load.LoadInters;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

public class StartInter implements StartMap {

    /**
     * 创建interceptor对象
     * @param startParam
     * @throws Exception
     */
    @Override
    public void load(StartParam startParam) throws Exception {
        LoadInters.loadIntersList();
    }
}
