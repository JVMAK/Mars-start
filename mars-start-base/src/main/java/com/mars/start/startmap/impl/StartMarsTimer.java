package com.mars.start.startmap.impl;

import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

public class StartMarsTimer implements StartMap {

    /**
     * 加载timer对象
     * @param startParam
     * @throws Exception
     */
    @Override
    public void load(StartParam startParam) throws Exception {
        com.mars.timer.load.LoadMarsTimer.loadMarsTimers();
    }
}
