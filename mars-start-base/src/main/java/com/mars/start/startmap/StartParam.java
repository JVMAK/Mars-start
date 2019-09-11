package com.mars.start.startmap;

import com.mars.jdbc.base.BaseInitJdbc;

/**
 * 启动框架的参数
 */
public class StartParam {

    /**
     * 启动类
     */
    private Class<?> clazz;
    /**
     * 启动类所在的包
     */
    private String startClassName;
    /**
     * 加载JDBC的类
     */
    private BaseInitJdbc baseInitJdbc;
    /**
     * 配置文件标识
     */
    private String suffix;

    public Class<?> getClazz() {
        return clazz;
    }

    public String getStartClassName() {
        return startClassName;
    }

    public void setStartClassName(String startClassName) {
        this.startClassName = startClassName;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public BaseInitJdbc getBaseInitJdbc() {
        return baseInitJdbc;
    }

    public void setBaseInitJdbc(BaseInitJdbc baseInitJdbc) {
        this.baseInitJdbc = baseInitJdbc;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
