package com.mars.start.startmap;

import com.mars.jdbc.base.BaseInitJdbc;

public class StartParam {

    private Class<?> clazz;

    private BaseInitJdbc baseInitJdbc;

    private String suffix;

    public Class<?> getClazz() {
        return clazz;
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
