package com.mars.start.base;

import com.mars.core.after.StartAfter;
import com.mars.core.constant.MarsConstant;
import com.mars.core.constant.MarsSpace;
import com.mars.core.load.LoadHelper;
import com.mars.core.load.WriteFields;
import com.mars.core.logger.MarsLogger;
import com.mars.jdbc.base.BaseInitJdbc;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;
import com.mars.timer.execute.ExecuteMarsTimer;

import java.util.Map;

/**
 * 单测启动器
 */
public class MarsJunitStart {

    private static MarsLogger log = MarsLogger.getLogger(MarsJunitStart.class);

    /**
     * 获取全局存储空间
     */
    private static MarsSpace constants = MarsSpace.getEasySpace();

    private static Map<Integer, StartMap> startList;

    public static void setStartList(Map<Integer, StartMap> startList) {
        MarsJunitStart.startList = startList;
    }

    /**
     * 启动Mars框架
     */
    public static void start(BaseInitJdbc baseInitJdbc, String packName, Object obj,String suffix) {
        try {
            if(constants.getAttr(MarsConstant.HAS_TEST) == null){
                log.info("程序启动中......");

                /* 加载框架数据 */
                load(baseInitJdbc,packName,suffix);

                /* 启动after方法 */
                StartAfter.after();

                /* 执行定时任务 */
                ExecuteMarsTimer.execute();

                /* 标记已经为单测创建过资源了 */
                constants.setAttr(MarsConstant.HAS_TEST,"yes");
            }

            /* 给单测注入属性 */
            autoWrite(obj);

            /* 标识是否已经启动 */
            constants.setAttr(MarsConstant.HAS_NETTY_START,"yes");

            log.info("开始执行单测......");
        } catch (Exception e) {
            log.error("",e);
            System.exit(0);
        }
    }

    /**
     * 加载所需的资源
     */
    private static void load(BaseInitJdbc baseInitJdbc,String packName,String suffix) throws Exception{

        StartParam startParam = new StartParam();
        startParam.setStartClassName(packName);
        startParam.setBaseInitJdbc(baseInitJdbc);
        startParam.setSuffix(suffix);

        for(int i=0; i < startList.size(); i++){
            startList.get(i).load(startParam);
        }
    }

    /**
     * 给单测注入属性
     */
    public static void autoWrite(Object obj) {
        try {
            Class cls = obj.getClass();
            WriteFields.writeFields(cls,obj,LoadHelper.getBeanObjectMap());
        } catch (Exception e){
            log.error("初始化单测出现异常",e);
        }
    }
}
