package com.example.generator.plugin;

import entity.EmployeeExample;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName MyFirstPlugin
 * @Description TODO
 * @Author CGH
 * @Date 2020/12/28 19:35
 * @Version 1.0
 */

/***
 * 完成插件签名
 *      告知MyBatis抽奖用于拦截那个对象的那个方法
 */
@Intercepts({
        @Signature(type= StatementHandler.class,method = "parameterize",args = java.sql.Statement.class)
})
public class MyFirstPlugin implements Interceptor {

    /***
     * intercept 拦截
     *      拦截目标对象的目标方法执行
     * @param invocation
     * @return
     * @throws Throwable
     */

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        System.out.println("MyFirstPlugin....intercept" + invocation.getMethod());
        // 拦截对象
        Object target = invocation.getTarget();
        // 获取target的元数据对象
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("cc:  "+value);
        // 修改sql
        entity.EmployeeExample employeeExample = new entity.EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andDIdEqualTo(8);
        metaObject.setValue("parameterHandler.parameterObject",employeeExample);
        Object proceed = invocation.proceed();

        return proceed;
    }

    /***
     * plugin 包装
     *      保证目标对象,为目标对象创建代理对象
     * @param target
     * @return
     */

    @Override
    public Object plugin(Object target) {

        System.out.println("MyFirstPlugin......plugin" + target);

        // 借助Plugin的wrap方法来使用当前Interceptor包装我们的目标对象
        Object wrap = Plugin.wrap(target, this);
        // 返回当前target创建的动态代理
        return wrap;
    }


    /***
     *  setProperties 属性注册
     *      将插件注册时的property属性设置进来
     *      property 指配置文件中的plugins属性
     * @param properties
     */

    @Override
    public void setProperties(Properties properties) {
        System.out.println("注册信息" + properties);
    }
}
