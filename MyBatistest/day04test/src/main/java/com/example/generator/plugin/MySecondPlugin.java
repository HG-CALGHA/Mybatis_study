package com.example.generator.plugin;


import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @ClassName MySecondPlugin
 * @Description TODO
 * @Author CGH
 * @Date 2020/12/28 20:08
 * @Version 1.0
 */

@Intercepts({
        @Signature(type= StatementHandler.class,method = "parameterize",args = java.sql.Statement.class)
})
public class MySecondPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("MySecondPlugin----intercept：  "+ invocation.getMethod());
        Object proceed = invocation.proceed();
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("MySecondPlugin----plugin  " + target);
        Object wrap = Plugin.wrap(target, this);
        return wrap;
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("MySecondPlugin----setProperties");
    }
}
