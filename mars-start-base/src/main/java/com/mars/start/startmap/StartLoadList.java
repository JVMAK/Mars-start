package com.mars.start.startmap;

import com.mars.start.startmap.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 启动框架需要加载的资源
 */
public class StartLoadList {

    /**
     * 启动框架需要加载的资源
     * @return 返回值
     */
    public static Map<Integer, StartMap> initStartList(){

        Map<Integer, StartMap> startList = new HashMap<>();

        startList.put(0, new StartCoreServlet());
        startList.put(1, new StartConfig());
        startList.put(2, new StartBeans());
        startList.put(3, new StartJDBC());
        startList.put(4, new StartBeanObject());
        startList.put(5, new StartController());
        startList.put(6, new StartInter());
        startList.put(7, new HasStart());
        startList.put(8, new StartMarsTimer());

        return startList;
    }
}
