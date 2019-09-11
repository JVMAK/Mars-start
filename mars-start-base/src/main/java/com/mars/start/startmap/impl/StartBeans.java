package com.mars.start.startmap.impl;

import com.mars.core.constant.MarsSpace;
import com.mars.core.load.LoadClass;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;

public class StartBeans implements StartMap {

    /**
     * 获取全局存储空间
     */
    private MarsSpace constants = MarsSpace.getEasySpace();

    /**
     * 扫描包
     * @param startParam
     * @throws Exception
     */
    @Override
    public void load(StartParam startParam) throws Exception {
        /*获取要扫描的包*/
        String className = getClassName(startParam.getClazz());

        /* 将要扫描的包名存到全局存储空间，给别的需要的地方使用 */
        constants.setAttr("rootPath", className);

        /* 获取此包下面的所有类（包括jar中的） */
        LoadClass.loadBeans(className);
    }

    /**
     * 截取main方法所在包名
     * @param clazz
     * @return
     * @throws Exception
     */
    private String getClassName(Class clazz) throws Exception {
        String className = clazz.getName();
        if(className.indexOf(".") < 0){
            throw new Exception("启动服务的main方法所在的类,必须放在两层包名中,比如[com.mars,com.test]等,不允许放在[com,cn]等包中,更不允许放在包外面");
        }
        return className.substring(0,className.lastIndexOf("."));
    }
}
