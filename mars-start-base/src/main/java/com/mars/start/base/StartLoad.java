package com.mars.start.base;

import com.mars.jdbc.base.BaseInitJdbc;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

import java.util.Map;

/**
 * 加载所需的资源
 */
public class StartLoad {

    /**
     * 加载所需的资源
     * @param baseInitJdbc jdbc加载器
     * @param packName 要扫描的包
     * @param suffix 配置文件后缀
     * @param startList 要加载的责任链
     * @throws Exception 异常
     */
    public static void load(BaseInitJdbc baseInitJdbc, Class<?> packName, String suffix, Map<Integer, StartMap> startList) throws Exception{

        StartParam startParam = new StartParam();
        startParam.setClazz(packName);
        startParam.setBaseInitJdbc(baseInitJdbc);
        startParam.setSuffix(suffix);

        for(int i=0; i < startList.size(); i++){
            startList.get(i).load(startParam);
        }
    }
}
