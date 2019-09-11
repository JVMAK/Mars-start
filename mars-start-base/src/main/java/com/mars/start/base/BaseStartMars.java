package com.mars.start.base;

import com.alibaba.fastjson.JSONObject;
import com.mars.core.after.StartAfter;
import com.mars.core.logger.MarsLogger;
import com.mars.core.util.ConfigUtil;
import com.mars.netty.server.MarsServer;
import com.mars.jdbc.base.BaseInitJdbc;
import com.mars.start.startmap.StartMap;
import com.mars.start.startmap.StartParam;
import com.mars.timer.execute.ExecuteMarsTimer;

import java.util.Map;

/**
 * 启动Mars框架
 * @author yuye
 *
 */
public class BaseStartMars {
	
	private static MarsLogger log = MarsLogger.getLogger(BaseStartMars.class);

	private static Map<Integer, StartMap> startList;

	public static void setStartList(Map<Integer, StartMap> startList) {
		BaseStartMars.startList = startList;
	}

	/**
	 * 启动Mars框架
	 * @param clazz
	 */
	public static void start(Class<?> clazz, BaseInitJdbc baseInitJdbc, String suffix) {
		try {
			
			log.info("程序启动中......");

			/* 加载框架数据 */
			load(clazz,baseInitJdbc,suffix);

			/* 启动netty */
			MarsServer.start(getPort());

		} catch (Exception e) {
			log.error("",e);
			System.exit(0);
		}
	}
	
	/**
	 * 加载所需的资源
	 */
	private static void load(Class<?> clazz, BaseInitJdbc baseInitJdbc,String suffix) throws Exception{
		StartParam startParam = new StartParam();
		startParam.setClazz(clazz);
		startParam.setBaseInitJdbc(baseInitJdbc);
		startParam.setSuffix(suffix);

		for(int i=0; i < startList.size(); i++){
			startList.get(i).load(startParam);
		}
	}


	
	/**
	 * 获取端口号，默认8080
	 * @return
	 */
	private static int getPort() {

		JSONObject jsonObject = ConfigUtil.getConfig();
		Object por = jsonObject.get("port");
		if(por!=null) {
			return Integer.parseInt(por.toString());
		}

		return 8080;
	}
}
