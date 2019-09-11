package com.mars.start.startmap.impl;

import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

public class StartJDBC implements StartMap {

    /**
     * 加载JDBC模块
     * @param startParam
     * @throws Exception
     */
    @Override
    public void load(StartParam startParam) throws Exception {
        if(startParam.getBaseInitJdbc() != null){
            startParam.getBaseInitJdbc().init();
        }
    }
}
