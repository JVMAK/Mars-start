package com.mars.start.startmap.impl;

import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

/**
 * 创建controller对象
 */
public class StartController implements StartMap {

    /**
     * 创建controller对象
     * @param startParam 参数
     * @throws Exception 异常
     */
    @Override
    public void load(StartParam startParam) throws Exception {
        com.mars.mvc.load.LoadController.loadContrl();
    }
}