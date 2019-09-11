package com.mars.start.startmap.impl;

import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

public class StartController implements StartMap {

    /**
     * 创建controller对象
     * @param startParam
     * @throws Exception
     */
    @Override
    public void load(StartParam startParam) throws Exception {
        com.mars.mvc.load.LoadController.loadContrl();
    }
}