package com.mars.junit;

import com.mars.start.base.MarsJunitStart;
import com.mars.start.startmap.StartLoadList;

/**
 * junit
 */
public abstract class MarsJunit {

    /**
     * 加载项目启动的必要数据
     * @param packName
     */
    public void init(String packName,String suffix){
        MarsJunitStart.setStartList(StartLoadList.initTestStartList());
        MarsJunitStart.start(null,packName,this,suffix);
    }

    /**
     * 加载项目启动的必要数据
     * @param packName
     */
    public void init(String packName){
        init(packName,null);
    }

    /**
     * 单测开始前
     */
    public abstract void before();
}
