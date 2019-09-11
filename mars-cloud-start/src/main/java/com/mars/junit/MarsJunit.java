package com.mars.junit;

import com.mars.cloud.registered.Registered;
import com.mars.mvc.load.LoadController;
import com.mars.mybatis.init.InitJdbc;
import com.mars.start.base.MarsJunitStart;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;
import com.mars.start.startmap.impl.*;
import org.junit.Before;

import java.util.HashMap;
import java.util.Map;

/**
 * junit
 */
public abstract class MarsJunit {

    /**
     * 加载项目启动的必要数据
     *
     * @param packName 包名
     */
    public void init(String packName, String suffix) {

        Map<Integer, StartMap> startList = new HashMap<>();
        startList.put(0, new StartConfig());
        startList.put(1, new StartBeans());
        startList.put(2, new StartJDBC());
        startList.put(3, new StartBeanObject());
        startList.put(4, new HasStart());
        startList.put(5, new StartMarsTimer());
        startList.put(6, new StartRegistered());
        startList.put(7, new StartAfter());
        startList.put(8, new StartExecuteTimer());

        MarsJunitStart.setStartList(startList);
        MarsJunitStart.start(new InitJdbc(), packName, this, suffix);
    }

    /**
     * 加载项目启动的必要数据
     *
     * @param packName 包名
     */
    public void init(String packName) {
        init(packName, null);
    }

    /**
     * 单测开始前
     */
    @Before
    public abstract void before();

    /**
     * 注册接口
     */
    static class StartRegistered implements StartMap {
        @Override
        public void load(StartParam startParam) throws Exception {
            LoadController.loadContrl();
            Registered.register();
        }
    }
}
