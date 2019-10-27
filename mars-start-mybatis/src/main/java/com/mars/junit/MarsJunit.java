package com.mars.junit;

import com.mars.jdbc.base.BaseInitJdbc;
import com.mars.mybatis.init.InitJdbc;
import com.mars.start.base.BaseJunit;

/**
 * junit
 */
public abstract class MarsJunit extends BaseJunit {

    @Override
    public BaseInitJdbc getBaseInitJdbc() {
        return new InitJdbc();
    }
}
