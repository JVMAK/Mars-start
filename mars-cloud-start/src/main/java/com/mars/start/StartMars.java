package com.mars.start;

import com.mars.cloud.registered.Registered;
import com.mars.junit.StartList;
import com.mars.mybatis.init.InitJdbc;
import com.mars.start.base.BaseStartMars;
import com.mars.start.startmap.StartLoadList;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 启动Mars框架
 *
 * @author yuye
 */
public class StartMars {

    /**
     * 启动Mars框架
     *
     * @param clazz 类
     */
    public static void start(Class<?> clazz, String[] args) {
        Map<Integer, StartMap> startMapMap = StartLoadList.initStartList();
        startMapMap.put(9, new StartRegistered());
        BaseStartMars.setStartList(startMapMap);

        if (args != null && args[0] != null) {
            BaseStartMars.start(clazz, new InitJdbc(), args[0]);
        } else {
            BaseStartMars.start(clazz, new InitJdbc(), null);
        }
    }

    /**
     * 启动Mars框架
     *
     * @param clazz 类
     */
    public static void start(Class<?> clazz) {
        start(clazz,null);
    }

    static class StartRegistered implements StartMap {
        @Override
        public void load(StartParam startParam) throws Exception {
            Registered.register();
        }
    }
}
