package com.mars.start.base;

import com.alibaba.fastjson.JSONObject;
import com.mars.core.util.ConfigUtil;
import com.mars.jdbc.load.InitJdbc;
import com.mars.netty.server.MarsServer;
import com.mars.start.startmap.StartMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 启动Mars框架
 * @author yuye
 *
 */
public class BaseStartMars {
	
	private static Logger log = LoggerFactory.getLogger(BaseStartMars.class);

	private static Map<Integer, StartMap> startList;

	public static void setStartList(Map<Integer, StartMap> startList) {
		BaseStartMars.startList = startList;
	}

	/**
	 * 启动Mars框架
	 * @param clazz
	 */
	public static void start(Class<?> clazz, InitJdbc initJdbc, String suffix) {
		try {
			
			log.info("程序启动中......");

			/* 加载框架数据 */
			StartLoad.load(initJdbc,clazz,suffix,startList);

			/* 启动netty */
			MarsServer.start(getPort());

		} catch (Exception e) {
			log.error("启动失败",e);
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
