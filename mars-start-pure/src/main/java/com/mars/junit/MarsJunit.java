package com.mars.junit;

import com.mars.mj.init.InitJdbc;
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
    public void init(Class packName,String suffix){
        MarsJunitStart.setStartList(StartLoadList.initTestStartList());
        MarsJunitStart.start(new InitJdbc(),packName,this,suffix);
    }

    /**
     * 加载项目启动的必要数据
     * @param packName
     */
    public void init(Class packName){
        init(packName,null);
    }

    /**
     * 单测开始前
     */
    public abstract void before();
}
