package com.mars.start.base;

import com.mars.core.annotation.MarsTest;
import com.mars.jdbc.base.BaseInitJdbc;
import com.mars.start.startmap.StartLoadList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 单测基类
 */
public abstract class BaseJunit {

    private Logger logger = LoggerFactory.getLogger(BaseJunit.class);

    public BaseJunit(){
        MarsTest marsTest = this.getClass().getAnnotation(MarsTest.class);
        if(marsTest == null || marsTest.startClass() == null){
            logger.error("没有正确的配置MarsTest注解");
        } else {
            init(marsTest.startClass(),marsTest.config());
        }
    }

    /**
     * 加载单测需要的资源
     * @param packName 包
     * @param suffix 后缀
     */
    public void init(Class packName,String suffix){
        if(suffix != null && suffix.equals("")){
            suffix = null;
        }

        MarsJunitStart.setStartList(StartLoadList.initTestStartList());
        MarsJunitStart.start(getBaseInitJdbc(),packName,this,suffix);
    }

    /**
     * 获取加载jdbc的类
     * @return 类
     */
    public abstract BaseInitJdbc getBaseInitJdbc();
}
