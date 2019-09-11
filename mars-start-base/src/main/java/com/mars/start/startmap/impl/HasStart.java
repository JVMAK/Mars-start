package com.mars.start.startmap.impl;

import com.mars.core.constant.MarsConstant;
import com.mars.core.constant.MarsSpace;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

public class HasStart implements StartMap {

    /**
     * 获取全局存储空间
     */
    private MarsSpace constants = MarsSpace.getEasySpace();

    /**
     * 标识createBean方法已经调用完毕
     * @param startParam
     * @throws Exception
     */
    @Override
    public void load(StartParam startParam) throws Exception {
        constants.setAttr(MarsConstant.HAS_START,"yes");
    }
}